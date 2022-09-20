package com.github.alexeysharandin.quarkus.jef.example.controller;

import com.github.alexeysharandin.quarkus.jef.example.model.Bmp280DTO;
import com.github.alexeysharandin.quarkus.jef.example.model.GpsDTO;
import com.github.alexeysharandin.quarkus.jef.example.model.StateDTO;
import com.github.alexeysharandin.quarkus.jef.example.services.*;
import io.smallrye.mutiny.Uni;

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
    BH1750Service light;

    @Inject
    Neo6mService gps;

    @Inject
    Bmp280Service bmp280;

    @Inject
    GpioService gpio;

    @Inject
    FlashService flash;

    @GET
    @Path("light")
    public Uni<Float> light() throws IOException {
        return Uni.createFrom().item(light.value());
    }

    @GET
    @Path("gps")
    public Uni<GpsDTO> gps() {
        return Uni.createFrom().item(gps.coords());
    }

    @GET
    @Path("bmp280")
    public Uni<Bmp280DTO> bmp280() throws IOException {
        return Uni.createFrom().item(bmp280.data());
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
