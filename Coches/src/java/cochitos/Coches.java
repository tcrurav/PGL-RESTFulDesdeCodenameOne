/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cochitos;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Tiburcio
 */
@Path("coches")
public class Coches {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of Coches
     */
    public Coches() {
    }

    /**
     * Retrieves representation of an instance of Coches.Coches
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        return "{ \"marca\": \"Audi\", \"modelo\": \"A3\"}";
    }
    
    @GET
    @Path("marca/{marquita}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson(@PathParam("marquita") String marquita) {
        int numero = 0;
        switch(marquita){
            case "Audi":
                numero = 10;
                break;
            case "BMW":
                numero = 20;
                break;
        }

        return "{ \"marca\": \"" + marquita + "\", \"stock\": \"" + numero + "\"}";
    }
    
    
    /**
     * PUT method for updating or creating an instance of Coches
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
