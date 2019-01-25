package com.example.restejbjpa.rest;

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

import com.example.restejbjpa.domain.Guitar;
import com.example.restejbjpa.domain.Owner;
import com.example.restejbjpa.domain.Serial;
import com.example.restejbjpa.service.GuitarManager;
import com.example.restejbjpa.service.SerialManager;

@Path("guitar")
public class GuitarRESTService {

	@Inject
	private GuitarManager gm;
	
	@Inject
	private SerialManager sm;

	@GET
	@Path("/{guitarId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Guitar getGuitar(@PathParam("guitarId") Integer id) {
		Guitar p = gm.getGuitar(id);
		return p;
	}
	
	@GET
	@Path("/bySerialNumber")
	@Produces(MediaType.APPLICATION_JSON)
	public Guitar getGuitarBySerialNumber(@QueryParam("serialNumber") Long serialNumber) {
		Guitar p = gm.getGuitarBySerialNumber(serialNumber);
		
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
		Guitar guitar = new Guitar(price);
		gm.addGuitar(guitar);

		return Response.status(201).entity("Guitar").build();
	}
	
	@PUT
	@Path("/{guitarId}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateGuitar(@PathParam("guitarId") Integer id, 
	                               @QueryParam("producer") String producer, @QueryParam("price") double price) {

		Guitar guitar = gm.getGuitar(id);
	    if (guitar == null) {
	        throw new WebApplicationException("Can't find it", 404);
	    }

	    guitar.setPrice(price);

	    return Response.status(200).entity("Guitar").build();
	}
	
    @GET
    @Path("/getOwners/{guitarId}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Owner> getOwnersOfGuitar(@PathParam("guitarId") Integer id){
        return gm.getOwnersOfGuitar(id);
    }
    
    @POST
    @Path("/setSerial/{guitarId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response setGuitarSerial(@PathParam("guitarId") Integer id, @QueryParam("serialNumber") Long serialNumber){
        Serial serial = new Serial(serialNumber);
        sm.addSerial(serial);
        
        Guitar guitar = gm.getGuitar(id);
        
        guitar.setSerial(serial);
        gm.updateGuitar(guitar);
        
        return Response.status(200).build();
    }

	@DELETE
	public Response clearGuitars() {
		gm.deleteAllGuitars();
		return Response.status(200).build();
	}
}
