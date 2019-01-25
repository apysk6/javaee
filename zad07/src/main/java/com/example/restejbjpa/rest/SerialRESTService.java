package com.example.restejbjpa.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.example.restejbjpa.domain.Serial;
import com.example.restejbjpa.service.SerialManager;

@Path("serial")
public class SerialRESTService {

    @EJB
    SerialManager om;

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addSerial(@QueryParam("serialNumber") long serialNumber) {
		Serial serial = new Serial(serialNumber);
		om.addSerial(serial);

		return Response.status(201).entity("Serial").build();
	}

    @PUT
    @Path("/{serialId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateSerial(@PathParam("serialId") Integer id, @QueryParam("serialNumber") long serialNumber) {
        Serial serial = om.getSerial(id);

        serial.setSerialNumber(serialNumber);

        om.updateSerial(serial);

        return Response.status(Response.Status.CREATED).build();
    }

    @GET
    @Path("/test")
    @Produces(MediaType.TEXT_PLAIN)
    public String test(){
        return "Serial REST Service is running.";
    }

    @GET
    @Path("/{serialId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Serial getSerial(@PathParam("serialId") Integer id){
        return om.getSerial(id);
    }

    @GET
    @Path("/allSerials")
    @Produces(MediaType.APPLICATION_JSON)
    @SuppressWarnings("unchecked")
    public List<Serial> getAllSerials(){
        return om.getAllSerials();
    }
	
	@DELETE
	public Response clearSerials() {
		om.deleteAllSerials();
		return Response.status(200).build();
	}
}