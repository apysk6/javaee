package com.example.restejbjpa.rest;

import java.util.List;

import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.ws.rs.*;
import javax.ws.rs.core.*;


import com.example.restejbjpa.service.OwnerManager;

@Path("query")
public class QueryRESTService {

	@Inject
	OwnerManager om;
	
	@GET
	@Path("/{surname}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getOwnerGuitars(@PathParam("surname") String surname) {
		
		List<Object[]> rowOwnerGuitars = om.getOwnerGuitars(surname);
        JsonArrayBuilder ownerGuitars = Json.createArrayBuilder();

        for (Object[] ownerGuitar: rowOwnerGuitars) {
            double guitarPrice = (double) ownerGuitar[0];
            String ownerName = (String) ownerGuitar[1];
            String ownerSurname = (String) ownerGuitar[2];

            ownerGuitars.add(Json.createObjectBuilder().
                    add("price", guitarPrice).
                    add("ownerName", ownerName).
                    add("ownerSurname", ownerSurname)
            );
        }

        JsonObject json = Json.createObjectBuilder().add("result", ownerGuitars).build();

        return Response.ok(json, MediaType.APPLICATION_JSON).build();
	}
}
