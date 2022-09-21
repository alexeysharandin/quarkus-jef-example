package com.github.alexeysharandin.quarkus.jef.example.services;

import com.github.alexeysharandin.quarkus.jef.example.model.Bmp280DTO;
import com.github.alexeysharandin.quarkus.jef.example.model.GpsDTO;
import io.quarkus.scheduler.Scheduled;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.io.IOException;

@ApplicationScoped
public class ScheduledService {
    private final static Logger logger = LogManager.getLogger(ScheduledService.class);

    @Inject
    BH1750Service bh1750Service;

    @Inject
    Neo6mService neo6mService;

    @Inject
    Bmp280Service bmp280Service;

    private Float light;
    private GpsDTO coords;

    private Bmp280DTO data;

    @Scheduled(every="5s")
    void trigger() throws IOException {
        logger.info("Process devices data started");
        light = bh1750Service.value();
        coords = neo6mService.coords();
        data = bmp280Service.data();
        logger.info("Process devices data finished");
    }

    public Float light() {
        return light;
    }

    public GpsDTO coords() {
        return coords;
    }

    public Bmp280DTO data() {
        return data;
    }
}
