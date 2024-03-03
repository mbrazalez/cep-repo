package cep;

import java.time.LocalTime;

public class Event {
    public String  station;
    public LocalTime timestamp;
    public float value;

    public Event(String station, LocalTime timestamp, float value){
        this.station = station;
        this.timestamp = timestamp;
        this.value = value;
    }

    public String getStation() { return this.station; }
    public LocalTime getTimestamp() {
        return LocalTime.now();
    }
    public float getValue() {
        return value;
    }

}
