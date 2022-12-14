package com.github.alexeysharandin.quarkus.jef.example.services;

import com.github.alexeysharandin.quarkus.jef.example.model.Bmp280DTO;
import io.quarkiverse.jef.java.embedded.framework.devices.library.bosch.bcm280.*;
import io.quarkiverse.jef.java.embedded.framework.devices.library.rohm.bh750fvi.BH1750FVI;
import io.quarkiverse.jef.java.embedded.framework.linux.i2c.I2CBus;
import io.quarkiverse.jef.java.embedded.framework.runtime.i2c.I2C;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import java.io.IOException;

@ApplicationScoped
public class Bmp280Service {
    private final static Logger logger = LogManager.getLogger(Bmp280Service.class);
    @I2C(name = "i2c1")
    I2CBus bus;

    private BMP280 bmp280;


    @PostConstruct
    void init() throws IOException {
        logger.info("Init BMP280");
        bmp280 = new BMP280(bus, I2CAddress.I2C_ADDRESS1);
        bmp280.setPowerMode(PowerMode.BMP280_NORMAL_MODE);
        bmp280.setTemperatureOversampling(TemperatureOversampling.ULTRA_HIGH);
        bmp280.setPressureOversampling(PressureOversampling.ULTRA_HIGH);
        bmp280.setIrrFilter(IrrFilter.COEFF_16);
        bmp280.setStandbyTime(StandbyTime.STANDBY_TIME_250_MS);

        logger.info("BMP280 Done");
    }

    public Bmp280DTO data() throws IOException {
        BMP280.BMP280Data data = bmp280.getBMP280Data();
        return new Bmp280DTO(data.getPressure(), data.getTemperatureCelsius(), data.getAltitude());
    }
}
