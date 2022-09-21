package com.github.alexeysharandin.quarkus.jef.example.controller;

import com.github.alexeysharandin.quarkus.jef.example.model.Bmp280DTO;
import com.github.alexeysharandin.quarkus.jef.example.model.GpsDTO;
import com.github.alexeysharandin.quarkus.jef.example.model.StateDTO;
import com.github.alexeysharandin.quarkus.jef.example.services.FlashService;
import com.github.alexeysharandin.quarkus.jef.example.services.GpioService;
import com.github.alexeysharandin.quarkus.jef.example.services.ScheduledService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;

@Path("/api/v1")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RestController {
    @Inject
    GpioService gpio;

    @Inject
    ScheduledService scheduled;

    @Inject
    FlashService flash;

    @GET
    @Path("light")
    public Float light() throws IOException {
        return scheduled.light();
    }

    @GET
    @Path("gps")
    public GpsDTO gps() {
        return scheduled.coords();
    }

    @GET
    @Path("bmp280")
    public Bmp280DTO bmp280() throws IOException {
        return scheduled.data();
    }

    @GET
    @Path("gpio/{status}")
    public void gpio(@PathParam("status") boolean status) {
        gpio.change(status);
    }

    @GET
    @Path("flash")
    public StateDTO load() throws IOException {
        return flash.load();
    }

    @POST
    @Path("flash")
    public Response save(StateDTO dto) throws IOException {
        flash.save(dto);
        return Response.ok().build();
    }

    @DELETE
    @Path("flash")
    public Response delete() throws IOException {
        flash.delete();
        return Response.ok().build();
    }
}
