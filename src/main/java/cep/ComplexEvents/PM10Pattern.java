package cep.ComplexEvents;

public class PM10Pattern implements PatternDefinition {
    public String patternName = "HighPollution";

    @Override
    public String getDefinedPattern() {
        return "@Name(\"" + patternName + "\") insert into " + patternName +
                " SELECT current_timestamp as timestamp, station, AVG(value) as averagePM10 " +
                "FROM PM10Event.win:time_batch(10 seconds) " +
                "GROUP BY station " +
                "HAVING AVG(value) > 10";
    }
}
