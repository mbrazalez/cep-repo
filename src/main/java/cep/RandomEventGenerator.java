package cep;

import cep.ComplexEvents.PM10Pattern;
import cep.SimpleEvents.PM10Event;
import java.time.LocalTime;
import java.util.Random;

public class RandomEventGenerator implements Runnable{
    private String[] stations = new String[] {"Avenida España","La feria","Los titis","Paseo Simon Abril"};

    private int numEvents;
    private CEPEngineFactory cepEngineFactory = new CEPEngineFactory();

    public RandomEventGenerator(int numEvents){
        this.numEvents = numEvents;
    }

    @Override
    public void run() {
        this.cepEngineFactory.createNewSchema(PM10Event.class);
        this.cepEngineFactory.addNewPattern(new PM10Pattern().getDefinedPattern());
        System.out.printf("\n*************************************");
        System.out.printf("\nThe events simulation has started!");
        System.out.printf("\n*************************************");

        for (int i=0; i<this.numEvents; i++){
            int randomPos = new Random().nextInt(4);
            PM10Event pm10Event = new PM10Event(this.stations[0], LocalTime.now(), new Random().nextInt(20));
            System.out.printf("\nSending a new PM10 event w/ value "+ pm10Event.getValue());
            this.cepEngineFactory.sendEvent(pm10Event);
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }

    }
}
