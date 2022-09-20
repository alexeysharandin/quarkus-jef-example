package com.github.alexeysharandin.quarkus.jef.example.services;

import com.github.alexeysharandin.quarkus.jef.example.model.StateDTO;
import io.quarkiverse.jef.java.embedded.framework.devices.library.bosch.bcm280.BMP280;
import io.quarkiverse.jef.java.embedded.framework.devices.library.bosch.bcm280.I2CAddress;
import io.quarkiverse.jef.java.embedded.framework.devices.library.winbond.w25x.W25xFlash;
import io.quarkiverse.jef.java.embedded.framework.linux.spi.SpiBus;
import io.quarkiverse.jef.java.embedded.framework.runtime.spi.SPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import java.io.IOException;
import java.nio.ByteBuffer;

@ApplicationScoped
public class FlashService {
    private final static Logger logger = LogManager.getLogger(FlashService.class);

    @SPI(name = "spi1")
    SpiBus bus;

    W25xFlash flash;

    @PostConstruct
    void init() throws IOException {
        logger.info("Init W25xFlash flash");
        flash = new W25xFlash(bus);
        int manufacturerID = flash.getManufacturerID();
        int memoryType = flash.getMemoryType();
        int capacity = flash.getCapacity();
        String chipID = flash.getChipID();
        boolean busy = flash.isBusy();
        logger.info("manufacturerID = 0x" + Integer.toHexString(manufacturerID));
        logger.info("memoryType = 0x" + Integer.toHexString(memoryType));
        logger.info("capacity = 0x" + Integer.toHexString(capacity));
        logger.info("chipID = " + chipID);
        logger.info("busy = " + busy);
        logger.info("Done");
    }

    public StateDTO load() throws IOException {
        StateDTO dto = new StateDTO();
        ByteBuffer read = flash.read(0, StateDTO.SIZE);
        dto.lux = read.getFloat();
        dto.gpio = read.get() == 1;
        dto.longitude = read.getDouble();
        dto.latitude = read.getDouble();
        dto.pressure = read.getDouble();
        dto.temperature = read.getDouble();
        dto.altitude = read.getDouble();
        return dto;
    }

    public void save(StateDTO dto) throws IOException {
        ByteBuffer buf = ByteBuffer.allocate(StateDTO.SIZE);
        buf.putFloat(dto.lux);
        buf.put((byte) (dto.gpio ? 1 : 0));
        buf.putDouble(dto.longitude);
        buf.putDouble(dto.latitude);
        buf.putDouble(dto.pressure);
        buf.putDouble(dto.temperature);
        buf.putDouble(dto.altitude);
        flash.pageWrite(0, 0, buf.array());
    }

    public void delete() throws IOException {
        flash.pageWrite(0, 0, new byte[StateDTO.SIZE]);
    }
}
