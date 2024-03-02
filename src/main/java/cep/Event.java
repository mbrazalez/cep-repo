package cep;

import java.util.Date;

public class Event {
    private String  station;
    private Date timestamp;
    private float value;

    public Event(String station, Date timestamp, float value){
        this.station = station;
        this.timestamp = timestamp;
        this.value = value;
    }

    public String getStation() { return this.station; }
    public Date getTimestamp() {
        return timestamp;
    }
    public float getValue() {
        return value;
    }
}
