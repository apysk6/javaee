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

import com.example.restejbjpa.domain.Guitar;
import com.example.restejbjpa.domain.Producer;
import com.example.restejbjpa.service.GuitarManager;
import com.example.restejbjpa.service.ProducerManager;

@Path("producer")
public class ProducerRESTService {

    @EJB
    ProducerManager pm;
    
    @EJB
    GuitarManager gm;

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addProducer(@QueryParam("name") String name) {
		Producer producer = new Producer(name);
		pm.addProducer(producer);

		return Response.status(201).entity("Producer").build();
	}

    @PUT
    @Path("/{producerId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateProducer(@PathParam("producerId") Integer id, @QueryParam("name") String name) {
    	Producer producer = pm.getProducer(id);

    	producer.setName(name);

        pm.updateProducer(producer);

        return Response.status(Response.Status.CREATED).build();
    }

    @GET
    @Path("/test")
    @Produces(MediaType.TEXT_PLAIN)
    public String test(){
        return "Producer REST Service is running.";
    }
    
    @GET
    @Path("/getCount/{producerName}")
    @Produces(MediaType.APPLICATION_JSON)
    public Object getCountGuitarByProducerName(@PathParam("producerName") String producerName) {
    	return pm.getCountByProducer(producerName); 
    }

    @GET
    @Path("/{producerId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Producer getProducer(@PathParam("producerId") Integer id){
        return pm.getProducer(id);
    }
    
    @GET
    @Path("/onetomany")
    @Produces(MediaType.APPLICATION_JSON)
    public Response makeOneToMany(){
    	
       List<Guitar> guitars = new ArrayList<Guitar>();
    	
       Guitar guitar = new Guitar(500);
       Guitar guitar2 = new Guitar(300);
       
       guitars.add(guitar);
       guitars.add(guitar2);
       
       Producer producer = new Producer("Gibson");
       producer.setGuitars(guitars);
       
       guitar.setProducer(producer);
       guitar2.setProducer(producer);
       
       pm.addProducer(producer);
       
       
       return Response.status(200).build();
    }

    @GET
    @Path("/allProducers")
    @Produces(MediaType.APPLICATION_JSON)
    @SuppressWarnings("unchecked")
    public List<Producer> getAllProducers(){
        return pm.getAllProducers();
    }
    
    @GET
    @Path("/getGuitars/{producerId}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Guitar> getGuitarsOfProducer(@PathParam("producerId") Integer id){
        return pm.getGuitarsOfProducer(id);
    }
	
	@DELETE
	public Response clearProducers() {
		pm.deleteAllProducers();
		return Response.status(200).build();
	}
}
