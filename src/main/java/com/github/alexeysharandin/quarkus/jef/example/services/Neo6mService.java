package com.github.alexeysharandin.quarkus.jef.example.services;

import com.github.alexeysharandin.quarkus.jef.example.model.GpsDTO;
import io.quarkiverse.jef.java.embedded.framework.devices.library.ubox.Neo6m;
import io.quarkiverse.jef.java.embedded.framework.linux.serial.SerialBus;
import io.quarkiverse.jef.java.embedded.framework.runtime.serial.Serial;
import io.quarkiverse.jef.java.embedded.framework.tools.nmea0183.*;
import io.vertx.core.Vertx;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

import static java.lang.Thread.MIN_PRIORITY;

@ApplicationScoped
public class Neo6mService {
    private final static Logger logger = LogManager.getLogger(FlashService.class);

    @Serial(name = "ama1")
    SerialBus bus;

    Thread thread;

    GpsDTO dto;

    @PostConstruct
    void init() throws IOException {
        logger.info("Init Neo6m");
        dto = new GpsDTO();
        thread = new Thread(getRunnable());
        thread.setPriority(MIN_PRIORITY);
        thread.start();
        logger.info("Neo6m Done");
    }

    private Runnable getRunnable() {
        return () -> {
            try {
                Neo6m m = new Neo6m(bus, new Nmea0183Listener() {
                    @Override
                    public void handle(GGARecord record) {
                        dto.longitude = record.getLongitude();
                        dto.latitude = record.getLatitude();
                    }
                });
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        };
    }

    public GpsDTO coords() {
        return dto;
    }
}
