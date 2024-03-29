package com.jaxwsetudiants.gestionetudiants.config;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider

public class JersyException implements ExceptionMapper<Exception> {

    @Override
    public Response toResponse(final Exception e) {
        return Response.serverError().entity(e.getMessage()).build();
    }
}

