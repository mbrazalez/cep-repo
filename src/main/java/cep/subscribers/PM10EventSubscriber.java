package cep.subscribers;

import java.util.Map;

public class PM10EventSubscriber implements EventSubscriber{
    public String patternName = "HighPollution";

    @Override
    public String getDefinedPattern() {
        return "@Name(\"" + patternName + "\") insert into " + patternName +
                " SELECT current_timestamp as timestamp, station, AVG(value) as averagePM10 " +
                "FROM PM10Event.win:time_batch(20 seconds) " +
                "GROUP BY station " +
                "HAVING AVG(value) > 10";
    }


    public void update(Map<String, Float> eventMap) {
        Float station = (Float) eventMap.get("averagePM10");
        System.out.printf(station.toString());
        //Date eventTime = (Date) eventMap.get("eventTime");
        //Double avgPM10 = (Double) eventMap.get("averagePM10");

        StringBuilder sb = new StringBuilder();
        sb.append("\n*************************************************************************");
        sb.append("\n* [ALERT] : HIGH PM10 LEVELS FOUND! ");
        sb.append("\n*" + station + " at " + " with a " + " level" );
        sb.append("\n*************************************************************************");
    }

}
