package cep;

import cep.subscribers.PM10EventSubscriber;
import com.espertech.esper.client.Configuration;
import com.espertech.esper.client.EPServiceProvider;
import com.espertech.esper.client.EPServiceProviderManager;
import com.espertech.esper.client.EPStatement;

public class CEPEngineFactory {
    private EPServiceProvider epServiceProvider;
    private EPStatement pm10EventStatement;
    private PM10EventSubscriber pm10EventSubscriber;

    public CEPEngineFactory(){
        Configuration conf = new Configuration();
        createPM10schema(conf);
        this.epServiceProvider = EPServiceProviderManager.getDefaultProvider(conf);
        this.createPM10ComplexEvent();
    }

    private static void createPM10schema(Configuration config){
        config.addEventType(PM10Event.class);
        System.out.printf("******************************************************");
        System.out.printf("PM10 Simple Event Schema Created!");
        System.out.printf("******************************************************");
    }

    private void createPM10ComplexEvent(){
        this.pm10EventStatement = this.epServiceProvider.getEPAdministrator().createEPL(this.pm10EventSubscriber.getDefinedPattern());
        this.pm10EventStatement.setSubscriber(this.pm10EventSubscriber);
        System.out.printf("******************************************************");
        System.out.printf("CEP Engine is ready for processing the incoming data!");
        System.out.printf("******************************************************");
    }

}
