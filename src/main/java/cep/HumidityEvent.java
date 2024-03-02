package cep;

import java.util.Date;

public class HumidityEvent extends Event {
    public HumidityEvent(String station, Date timestamp, float value){
       super(station, timestamp, value);
    }

    @Override
    public String toString() {
        return "HumidityEvent [" + this.getValue() + "]";
    }
}
