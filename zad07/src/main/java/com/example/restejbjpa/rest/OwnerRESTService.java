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
	public Response addGuitar(@QueryParam("name") String name, @QueryParam("surname") String surname, @QueryParam("age") int age) {
		Owner owner = new Owner(name, surname, age);
		om.addOwner(owner);

		return Response.status(201).entity("Owner").build();
	}

    @PUT
    @Path("/{ownerId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateOwner(@PathParam("ownerId") Integer id, Owner newOwner) {
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
    public Owner getOwner(@PathParam("ownerId") Integer id){
        return om.getOwner(id);
    }
    
    @GET
    @Path("/getBySurname/{surname}")
    @Produces(MediaType.APPLICATION_JSON)
    public Owner getOwnerBySurname(@PathParam("surname") String surname) {
    	return om.getOwnerBySurname(surname);
    }

    @GET
    @Path("/allOwners")
    @Produces(MediaType.APPLICATION_JSON)
    @SuppressWarnings("unchecked")
    public List<Owner> getAllOwners(){
        return om.getAllOwners();
    }
    
	@GET
	@Path("/manytomany")
	@Produces(MediaType.TEXT_PLAIN)
	public Response manyOwnersToManyGuitars() {
		
		Owner owner = new Owner("Theodore", "Jenkins", 22);
		
		Guitar g1 = new Guitar(450);
		Guitar g2 = new Guitar(650);
		
		List<Guitar> guitars = new ArrayList<Guitar>();
		guitars.add(g1);
		guitars.add(g2);
		
		owner.addGuitars(guitars);
		
		om.addOwner(owner);
		
		return Response.status(200).build();
	}

    @GET
    @Path("/getGuitars/{ownerId}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Guitar> getGuitarsOfOwner(@PathParam("ownerId") Integer id){
        return om.getGuitarsOfOwner(id);
    }
	
	@DELETE
	public Response clearOwners() {
		om.deleteAllOwners();
		return Response.status(200).build();
	}
}