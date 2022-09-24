package com.github.alexeysharandin.quarkus.jef.example.controller;

import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;
import io.quarkus.runtime.LaunchMode;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.net.ServerSocket;

@Path("")
public class PublicController {

    private final static Integer UI_DEBUG_PORT = 7001;
    private final static String PATH = "";
    @Inject
    Template index;


    @ConfigProperty(name="quarkus.http.port")
    Integer port;

    @GET
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance get() {
        TemplateInstance instance = index.instance();
        LaunchMode current = LaunchMode.current();
        String path;
        Integer currentPort;
        if(current.isDevOrTest()) {
            currentPort = UI_DEBUG_PORT;
            path = "";
        } else {
            currentPort = port;
            path = PATH;
        }
        instance.data("port", currentPort);
        instance.data("path", path);
        return instance;
    }

}