package cep;

import java.util.Date;
public class PM10Event extends Event {

    public PM10Event(String station, Date timestamp, float value){
       super(station, timestamp, value);
    }

    @Override
    public String toString() {
        return "PM10Event [" + this.getValue() + "]";
    }

}
