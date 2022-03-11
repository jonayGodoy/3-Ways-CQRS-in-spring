package com.webApplication.pages.backofficeStatsCQRS3.queries;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Date;


@Repository
public class BackofficeStatsRepository implements IBackofficeStatsRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public BackofficeStatsRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public BackofficeStats getStats(){
        var sqlQueryGetStats = "SELECT classname, time_stamp, (datajson::text) FROM commandrequestevents";
        var stats = jdbcTemplate.queryForList(sqlQueryGetStats).stream()
                .map((row) ->
                        new Stat(
                                (String)row.get("classname"),
                                ((Date)row.get("time_stamp")).toString(),
                                (String)row.get("datajson")
                        )).toList();
        var sqlQueryGetQuantityImg = "SELECT count(*) FROM commandrequestevents " +
                "WHERE classname LIKE '%createPizzaCQRS3.CreatePizzaRequestEvent'" +
                "AND datajson->>'img' = 'quad.png'";
        var quantityImgDtoWhenCreatedPizza = jdbcTemplate
                .queryForObject(sqlQueryGetQuantityImg, Integer.class);
        return new BackofficeStats(quantityImgDtoWhenCreatedPizza, stats);
    }

}
