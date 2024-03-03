package cep;

import cep.subscribers.RandomEventGenerator;

public class Main {
    public static void main(String[] args) {
        RandomEventGenerator randomEventGenerator = new RandomEventGenerator(100);
        randomEventGenerator.run();
    }
}