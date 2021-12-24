package com.example.final_jee.Controllers;

import com.example.final_jee.Services.*;
import com.example.final_jee.Utils.EntityManager;
import com.example.final_jee.models.Comment;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/client")
@RolesAllowed({"client"})
public class Client {
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


    @GET //4
    @Path("/getItems")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getItems() {
        return Response.ok().entity(itemService.getAllItems()).build();
    }

    @GET //5
    @Path("/getGoods")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getGoods() {
        return Response.ok().entity(goodService.getAllGoods()).build();
    }

    @POST //28
    @Path("/createComment")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Comment createComment(Comment comment) {
        commentService.createComment(comment.getComment());
        return comment;
    }

    @PUT
    @Path("/updateComment/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response updateComment(@PathParam("id") int id, String comment){
        commentService.updateComment(id, comment);
        return Response.ok().entity("Comment has been updated").build();
    }
}
