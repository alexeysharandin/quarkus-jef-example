package com.github.alexeysharandin.quarkus.jef.example.model;

public class StateDTO {
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

}
