package com.github.alexeysharandin.quarkus.jef.example.services;

import io.quarkiverse.jef.java.embedded.framework.devices.library.rohm.bh750fvi.BH1750FVI;
import io.quarkiverse.jef.java.embedded.framework.linux.i2c.I2CBus;
import io.quarkiverse.jef.java.embedded.framework.runtime.i2c.I2C;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

@ApplicationScoped
public class BH1750Service {
    private final static Logger logger = LogManager.getLogger(BH1750Service.class);

    @I2C(name = "i2c1")
    I2CBus bus;

    private BH1750FVI sensor;

    @PostConstruct
    void init() throws IOException {
        logger.info("Init BH1750 device");
        sensor = new BH1750FVI(bus, BH1750FVI.I2CAddress.I2C_ADDRESS_1);
        logger.info("BH1750 Done");
    }

    public float value() throws IOException {
        return sensor.readLightLevel();
    }

}
