package backoffice.queries.StatsCQRS3;

import java.util.List;

public class BackofficeStatsRequestDto {

    private int quantityImgDto;

    private List<StatDto> stats;

    public BackofficeStatsRequestDto(BackofficeStats requestDto) {
        this.quantityImgDto = requestDto.getQuantityImgDtoWhenCreatedPizza();
        this.stats = requestDto.getStats().stream()
                .map(x -> new StatDto(x.getClassName(),x.getTime_stamp(), x.getDatajson()))
                .toList();
    }

    public int getQuantityImgDtoWhenCreatedPizza() {
        return quantityImgDto;
    }

    public void setQuantityImgDto(int quantityImgDto) {
        this.quantityImgDto = quantityImgDto;
    }

    public List<StatDto> getStats() {
        return stats;
    }

    public void setStats(List<StatDto> stats) {
        this.stats = stats;
    }
}

