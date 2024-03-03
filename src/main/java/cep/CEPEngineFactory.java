package cep;

import cep.subscribers.PM10EventSubscriber;
import com.espertech.esper.client.*;

public class CEPEngineFactory {
    public EPServiceProvider epServiceProvider;
    public EPStatement pm10EventStatement;
    public PM10EventSubscriber pm10EventSubscriber;
    StatementAwareUpdateListener listener = new StatementAwareUpdateListener() {
        @Override
        public void update(EventBean[] newComplexEvents, EventBean[] oldComplexEvents, EPStatement detectedPattern, EPServiceProvider epService) {
            if (newComplexEvents != null){
                EventBean lastEvent = newComplexEvents[0];
                System.out.println("\n************************************************************************************************************************");
                System.out.println("[ALERT] : HIGH PM10 LEVELS FOUND! at " + lastEvent.get("station") + " with a " + lastEvent.get("averagePM10") + " level");
                System.out.println("**************************************************************************************************************************");

            }
        }
    };

    public CEPEngineFactory(){
        this.pm10EventSubscriber = new PM10EventSubscriber();
        Configuration conf = new Configuration();
        createPM10schema(conf);
        this.epServiceProvider = EPServiceProviderManager.getDefaultProvider(conf);
        this.createPM10ComplexEvent();
    }

    private void createPM10schema(Configuration config){
        config.addEventType(PM10Event.class);
        System.out.printf("\n******************************************************");
        System.out.printf("\nPM10 Simple Event Schema Created!");
        System.out.printf("\n******************************************************");
    }

    private void createPM10ComplexEvent(){
        this.pm10EventStatement = this.epServiceProvider.getEPAdministrator().createEPL(this.pm10EventSubscriber.getDefinedPattern());
        this.pm10EventStatement.addListener(listener);
        System.out.printf("\n******************************************************");
        System.out.printf("\nCEP Engine is ready for processing the incoming data!");
        System.out.printf("\n******************************************************");
    }

    public void sendEventToTheEngine(PM10Event event){
        this.epServiceProvider.getEPRuntime().sendEvent(event);
    }

}
