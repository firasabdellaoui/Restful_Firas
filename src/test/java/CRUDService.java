package test.java;

import entities.Produit;
import org.glassfish.jersey.client.ClientConfig;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class CRUDService {

    private static String baseURI="http://localhost:8080/RestAPIProject/rest/products";
    static WebTarget getWebTarget(){
        ClientConfig config= new ClientConfig();
        Client client = ClientBuilder.newClient(config);
        return client.target(baseURI);
    }
    static void afficherProduits(){

        WebTarget target =getWebTarget();
        String response = target.request().accept(MediaType.APPLICATION_JSON).get(String.class);
        System.out.println(response);
    }

   // static void ajouterProduit(){

      //  WebTarget target =getWebTarget(addURI);
      //  Produit product = new Produit("ZenProduit",888.88f);
      //  Response response= target.request().post(Entity.entity(product, MediaType.APPLICATION_JSON), Response.class);

      //  System.out.println(response.getLocation().toString());
    //}

    public static void main(String[] args){

        System.out.println("affichage des produits");
        afficherProduits();
     //   System.out.println("affichage des produits");
      //  ajouterProduit();
      //  System.out.println("affichage des produits");
       // afficherProduits();

    }
}
