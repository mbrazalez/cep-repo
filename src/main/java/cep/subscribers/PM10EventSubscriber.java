package cep.subscribers;

import cep.Event;
import cep.PM10Event;

import java.util.Date;
import java.util.Map;

public class PM10EventSubscriber implements EventSubscriber{
    private static final String patternName = "HighPollution";
    @Override
    public String getDefinedPattern() {
        return "@" + patternName + "insert into" + patternName +
                "SELECT current_timestamp as eventTime, station, AVG(p.value) as averagePM10" +
                "FROM PMM10Event.win:time(10)" +
                "WHERE averagePM10 < 10" +
                "GROUP BY station";
    }


    public void update(Map<String, String> eventMap) {
        String station = (String) eventMap.get("station");
        //Date eventTime = (Date) eventMap.get("eventTime");
        //Double avgPM10 = (Double) eventMap.get("averagePM10");

        StringBuilder sb = new StringBuilder();
        sb.append("*************************************************************************");
        sb.append("\n* [ALERT] : HIGH PM10 LEVELS FOUND! ");
        sb.append("\n*" + station + " at " + " with a " + " level" );
        sb.append("\n*************************************************************************");
    }
}
