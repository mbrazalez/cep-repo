package cep;

import java.time.LocalTime;

public class PM10Event extends Event {
    public PM10Event(String station, LocalTime timestamp, float value){
       super(station, timestamp, value);
    }

    @Override
    public String toString() {
        return "PM10Event [" + this.getValue() + "]";
    }

}
