package com.github.alexeysharandin.quarkus.jef.example.model;

public class StateDTO {
    private static StateDTO EMPTY = new StateDTO();
    public static transient int SIZE =
            Float.SIZE // lux
                    + 1 // gpio
                    + Double.SIZE // longitude
                    + Double.SIZE // latitude
                    + Double.SIZE // pressure
                    + Double.SIZE // temperature
                    + Double.SIZE; // altitude

    public float lux;
    public boolean gpio;
    public double longitude;
    public double latitude;
    public double pressure;
    public double temperature;
    public double altitude;

    public StateDTO() {
        lux = 0;
        gpio = false;
        longitude = 0;
        latitude = 0;
        pressure = 0;
        temperature = 0;
        altitude = 0;
    }

    public static StateDTO empty() {
        return EMPTY;
    }
}
