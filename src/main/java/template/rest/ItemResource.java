package template.rest;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import template.jpa.Item;

@Path("item")
public class ItemResource {
    @PersistenceContext
    private EntityManager entityManager;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public List<Item> getAll() {
        return Item.getAll(entityManager);
    }

    @Transactional
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public String createItem(@FormParam("text") String text) {
        Item.create(entityManager, text);
        return "OK. use browser's <back> button";
    }
}
