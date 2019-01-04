package com.example.restejbjpa.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
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
import com.example.restejbjpa.service.OwnerManager;

@Path("owner")
public class OwnerRESTService {

    @EJB
    OwnerManager om;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addProducer(Owner owner) {
    	Guitar guitar1 = new Guitar("Gibson", 144);
    	Guitar guitar2 = new Guitar("Epiphone", 300);

        List<Guitar> guitars = new ArrayList<>();
        guitars.add(guitar1);
        guitars.add(guitar2);

        owner.setGuitars(guitars);
        om.addOwner(owner);

        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("/{ownerId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateGuitar(@PathParam("ownerId") int id, Owner newOwner) {
        Owner owner = om.getOwner(id);

        owner.setName(newOwner.getName());
        owner.setSurname(newOwner.getSurname());
        owner.setAge(newOwner.getAge());

        om.updateOwner(owner);

        return Response.status(Response.Status.CREATED).build();
    }

    @GET
    @Path("/test")
    @Produces(MediaType.TEXT_PLAIN)
    public String test(){
        return "Owner REST Service is running.";
    }

    @GET
    @Path("/{ownerId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Owner getOwner(@PathParam("ownerId") int id){
        return om.getOwner(id);
    }

    @GET
    @Path("/allOwners")
    @Produces(MediaType.APPLICATION_JSON)
    @SuppressWarnings("unchecked")
    public List<Owner> getAllOwners(){
        return om.getAllOwners();
    }

	@DELETE
	public Response clearOwners() {
		om.deleteAllOwners();
		return Response.status(200).build();
	}
}