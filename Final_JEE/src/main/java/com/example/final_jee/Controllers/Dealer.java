package com.example.final_jee.Controllers;

import com.example.final_jee.Services.*;
import com.example.final_jee.Utils.EntityManager;
import com.example.final_jee.models.Good;
import com.example.final_jee.models.Item;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/dealer")
@RolesAllowed({"dealer"})
public class Dealer {
    @Inject
    EntityManager em;

    @EJB
    UserService userService;
    @EJB
    UserdetailService userdetailService;
    @EJB
    RoleService roleService;
    @EJB
    ItemService itemService;
    @EJB
    GoodService goodService;
    @EJB
    CostService costService;
    @EJB
    CommentService commentService;

    @POST //29
    @Path("/createItem")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Item createItem(Item item) {
        itemService.createItem(item.getName(), item.getPrice());
        return item;
    }

    @POST //30
    @Path("/createGood")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Good createGood(Good good) {
        goodService.createGood(good.getName(), good.getPrice());
        return good;
    }

    @PUT
    @Path("/updatePriceOfGood/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response updatePrice(@PathParam("id") int id, Double price){
        goodService.updatePrice(id, price);
        return Response.ok().entity("Good Price has been updated").build();
    }

}
