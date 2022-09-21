package com.github.alexeysharandin.quarkus.jef.example.model;

import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection
public class GpsDTO {

    public double longitude;
    public double latitude;

    public GpsDTO() {

    }
    public GpsDTO(double longitude, double latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }
}
