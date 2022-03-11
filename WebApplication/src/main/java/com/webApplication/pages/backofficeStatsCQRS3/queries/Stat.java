package app.cqrs.pages.backofficeStatsCQRS3.queries;

public class Stat {
    private String className;
    private String time_stamp;
    private String datajson;

    public Stat(String className, String time_stamp, String datajson) {
        this.className = className;
        this.time_stamp = time_stamp;
        this.datajson = datajson;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getTime_stamp() {
        return time_stamp;
    }

    public void setTime_stamp(String time_stamp) {
        this.time_stamp = time_stamp;
    }

    public String getDatajson() {
        return datajson;
    }

    public void setDatajson(String datajson) {
        this.datajson = datajson;
    }
}
