package com.example.restwsdemo.rest;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.example.restwsdemo.domain.Guitar;
import com.example.restwsdemo.service.GuitarManager;

@Path("guitar")
@Stateless
public class GuitarRESTService {

	@Inject
	private GuitarManager gm;

	@GET
	@Path("/{guitarId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Guitar getGuitar(@PathParam("guitarId") Integer id) {
		Guitar p = gm.getGuitar(id);
		return p;
	}

	@GET
	@Path("/allGuitars")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Guitar> getGuitars() {
		return gm.getAllGuitars();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addGuitar(@QueryParam("producer") String producer, @QueryParam("price") double price) {
		Guitar guitar = new Guitar(producer, price);
		gm.addGuitar(guitar);

		return Response.status(201).entity("Guitar").build();
	}
	
	@PUT
	@Path("/{guitarId}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateCustomer(@PathParam("guitarId") Integer id, 
	                               @QueryParam("producer") String producer, @QueryParam("price") double price) {

		Guitar guitar = gm.getGuitar(id);
	    if (guitar == null) {
	        throw new WebApplicationException("Can't find it", 404);
	    }

	    guitar.setProducer(producer);
	    guitar.setPrice(price);

	    return Response.status(200).entity("Guitar").build();
	}

	@DELETE
	public Response clearGuitars() {
		gm.deleteAllGuitars();
		return Response.status(200).build();
	}
}
