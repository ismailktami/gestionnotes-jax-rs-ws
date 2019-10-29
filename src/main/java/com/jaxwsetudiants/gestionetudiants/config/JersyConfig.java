package com.jaxwsetudiants.gestionetudiants.config;

import com.jaxwsetudiants.gestionetudiants.services.EtudiantServiceRest;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.ws.rs.ApplicationPath;

@Configuration
@ApplicationPath("/api")
public class JersyConfig extends ResourceConfig
{
   @PostConstruct
    public void init() {
       System.err.println("jehddjll");
       register(EtudiantServiceRest.class);
        register(JersyException.class);

    }
}
