package net.javacode.ws;

import java.net.*;
import java.util.*;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

import daoimp.DAOImpProduit;
import entities.Produit;
import idao.IDAOProduit;


@Path("/products")
public class ServiceProduit {
    private IDAOProduit dao =new  DAOImpProduit();

    // RESTful API methods go here...
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Produit> list() {
        return dao.listAll();
    }
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@PathParam("id") int id) {
        Produit product = dao.get(id);
        if (product != null) {
            return Response.ok(product, MediaType.APPLICATION_JSON).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response add(Produit product) throws URISyntaxException {
        int newProductId = dao.add(product);
        URI uri = new URI("/products/add" + newProductId);
        return Response.created(uri).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response update(@PathParam("id") int id, Produit product) {
        product.setId(id);
        if (dao.update(product)) {
            return Response.ok().build();
        } else {
            return Response.notModified().build();
        }
    }
    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") int id) {
        if (dao.delete(id)) {
            return Response.ok().build();
        } else {
            return Response.notModified().build();
        }
    }
}