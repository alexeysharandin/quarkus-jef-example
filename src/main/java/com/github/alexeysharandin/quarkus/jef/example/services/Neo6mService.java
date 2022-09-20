package com.github.alexeysharandin.quarkus.jef.example.services;

import com.github.alexeysharandin.quarkus.jef.example.model.GpsDTO;
import io.quarkiverse.jef.java.embedded.framework.devices.library.ubox.Neo6m;
import io.quarkiverse.jef.java.embedded.framework.linux.serial.SerialBus;
import io.quarkiverse.jef.java.embedded.framework.runtime.serial.Serial;
import io.quarkiverse.jef.java.embedded.framework.tools.nmea0183.*;
import io.smallrye.mutiny.Uni;
import io.vertx.mutiny.core.Vertx;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

@ApplicationScoped
public class Neo6mService {
    private final static Logger logger = LogManager.getLogger(FlashService.class);

    @Serial(name = "ama1")
    SerialBus bus;

    @Inject
    Vertx vertx;

    @PostConstruct
    void init() throws IOException {
        logger.info("Init Neo6m");
        Uni<Runnable> runnableUni = vertx.executeBlocking(Uni.createFrom().item(getRunnable()));
        System.out.println("runnableUni = " + runnableUni);

        logger.info("Done");
    }

    private Runnable getRunnable() {
        return () -> {
            try {
                Neo6m m = new Neo6m(bus, new Nmea0183Listener() {
                    @Override
                    public void handle(DHVRecord record) {
                        System.out.println("record = " + record);
                    }

                    @Override
                    public void handle(GGARecord record) {
                        System.out.println("record = " + record);
                    }

                    @Override
                    public void handle(GLLRecord record) {
                        System.out.println("record = " + record);
                    }

                    @Override
                    public void handle(GSARecord record) {
                        System.out.println("record = " + record);
                    }

                    @Override
                    public void handle(GSTRecord record) {
                        System.out.println("record = " + record);
                    }

                    @Override
                    public void handle(GSVRecord record) {
                        System.out.println("record = " + record);
                    }

                    @Override
                    public void handle(RMCRecord record) {
                        System.out.println("record = " + record);
                    }

                    @Override
                    public void handle(TXTRecord record) {
                        System.out.println("record = " + record);
                    }

                    @Override
                    public void handle(VTGRecord record) {
                        System.out.println("record = " + record);
                    }

                    @Override
                    public void handle(ZDARecord record) {
                        System.out.println("record = " + record);
                    }
                });
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        };
    }

    private void create() {

    }

    public GpsDTO coords() {
        return new GpsDTO(ThreadLocalRandom.current().nextDouble(), ThreadLocalRandom.current().nextDouble());
    }
}
