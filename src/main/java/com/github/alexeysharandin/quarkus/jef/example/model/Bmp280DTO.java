package com.github.alexeysharandin.quarkus.jef.example.model;

import io.quarkus.runtime.annotations.RegisterForReflection;

import java.util.concurrent.ThreadLocalRandom;

@RegisterForReflection
public class Bmp280DTO {
    public double pressure;
    public double temperature;
    public double altitude;

    public Bmp280DTO(double pressure, double temperature, double altitude) {
        this.pressure = pressure;
        this.temperature = temperature;
        this.altitude = altitude;
    }
}
