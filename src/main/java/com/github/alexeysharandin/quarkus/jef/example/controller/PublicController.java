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

@Path("")
public class PublicController {
    private final static String FILE_NAME = "main.js";
    private final static String DEV_PATH = "http://localhost:7001/" + FILE_NAME;
    private final static String PROD_PATH = "/js/" + FILE_NAME;
    @Inject
    Template index;


    @ConfigProperty(name="quarkus.http.port")
    String port;

    @GET
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance get() {
        TemplateInstance instance = index.instance();

        LaunchMode current = LaunchMode.current();
        String url;
        if(current.isDevOrTest()) {
            url = DEV_PATH;
        } else {
            url = PROD_PATH;
        }
        instance.data("url", url);
        return instance;
    }

}