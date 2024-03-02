package cep;

import java.util.Date;

public class WindSpeedEvent extends Event{

    public WindSpeedEvent(String station, Date timestamp, float value){
        super(station, timestamp, value);
    }

    @Override
    public String toString() {
        return "WindSpeedEvent [" + this.getValue() + "]";
    }

}
