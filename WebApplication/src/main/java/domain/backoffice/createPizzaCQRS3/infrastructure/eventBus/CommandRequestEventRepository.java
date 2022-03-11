package domain.backoffice.createPizzaCQRS3.createPizzaCQRS3.EventBus;

import domain.backoffice.createPizzaCQRS3.createPizzaCQRS3.RequestEvent;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class CommandRequestEventRepository {


    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CommandRequestEventRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(RequestEvent event){
        var sql = "INSERT INTO commandRequestEvents (className, time_stamp, datajson) VALUES (?, ?, ?::jsonb)";
        ObjectMapper mapper = new ObjectMapper();
        String jsonData = null;
        try {
            jsonData = mapper.writeValueAsString(event.getSerializable());
            jdbcTemplate.update(
                    sql,
                    event.getClass().getName(),
                    event.getTimespan(),
                    jsonData);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    };
}
