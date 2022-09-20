package com.github.alexeysharandin.quarkus.jef.example.services;

import io.quarkiverse.jef.java.embedded.framework.linux.gpio.GpioPin;
import io.quarkiverse.jef.java.embedded.framework.runtime.gpio.GPIO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.enterprise.context.ApplicationScoped;
import java.io.IOException;

@ApplicationScoped
public class GpioService {
    private final static Logger logger = LogManager.getLogger(GpioService.class);

    @GPIO(name = "<default>", number = 21)
    GpioPin pin;

    public void change(boolean on) {
        try {
            logger.info("Change GPIO pin 21 value to: {}", on);
            pin.setDirection(GpioPin.Direction.OUTPUT);
            pin.write(on ? GpioPin.State.HIGH : GpioPin.State.LOW);
            logger.info("Pin value changed");
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }
}
