package com.example.final_jee;

import com.example.final_jee.Services.*;
import com.example.final_jee.Utils.EntityManager;
import com.example.final_jee.Utils.Validators;
import com.example.final_jee.models.*;
import com.example.final_jee.repository.UserRepository;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/hello-world")
@RolesAllowed({"client", "dialer", "admin", "booker"})
public class HelloResource {
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

    @GET //0
    @Produces("text/plain")
    @RolesAllowed({"client", "dialer", "admin", "booker"})
    public String hello() {
        return "Hello, World!";
    }

//    @GET //1
//    @Path("/getUser")   // /////Works
//    @Produces(MediaType.APPLICATION_JSON)
//    @Consumes(MediaType.APPLICATION_JSON)
//    @PermitAll
//    public Response getUsers() {
//            return Response.ok().entity(userService.getAllUsers()).build();
//    }
//
//    @GET //2
//    @Path("/getRole")
//    @Produces(MediaType.APPLICATION_JSON)
//    @Consumes(MediaType.APPLICATION_JSON)
//    @PermitAll
//    public Response getRoles() {
//        return Response.ok().entity(roleService.getAllRoles()).build();
//    }
//
//    @GET //3
//    @Path("/getUserdetails")
//    @Produces(MediaType.APPLICATION_JSON)
//    @Consumes(MediaType.APPLICATION_JSON)
//    @PermitAll
//    public Response getUserdetails() {
//        return Response.ok().entity(userdetailService.getAllUserdetails()).build();
//    }
//
//    @GET //4
//    @Path("/getItems")
//    @Produces(MediaType.APPLICATION_JSON)
//    @Consumes(MediaType.APPLICATION_JSON)
//    @PermitAll
//    public Response getItems() {
//        return Response.ok().entity(itemService.getAllItems()).build();
//    }
//
//    @GET //5
//    @Path("/getGoods")
//    @Produces(MediaType.APPLICATION_JSON)
//    @Consumes(MediaType.APPLICATION_JSON)
//    @PermitAll
//    public Response getGoods() {
//        return Response.ok().entity(goodService.getAllGoods()).build();
//    }
//
//    @GET //6
//    @Path("/getCosts")
//    @Produces(MediaType.APPLICATION_JSON)
//    @Consumes(MediaType.APPLICATION_JSON)
//    @PermitAll
//    public Response getCosts() {
//        return Response.ok().entity(costService.getAllCosts()).build();
//    }
//
//    @GET //7
//    @Path("/getComments")
//    @Produces(MediaType.APPLICATION_JSON)
//    @Consumes(MediaType.APPLICATION_JSON)
//    @PermitAll
//    public Response getComments() {
//        return Response.ok().entity(commentService.getAllComments()).build();
//    }
//
//
//    @GET //8
//    @Path("/getUserById/{Id}")
//    @Produces(MediaType.APPLICATION_JSON)
//    @PermitAll
////    @RolesAllowed({"ADMIN", "Employee"})
//    public Response getUserById(
//            @DefaultValue("0")
//            @PathParam("Id") Long Id){
//        return Response.ok().entity(userService.getUserById(Id)).build();
//    }
//
//    @GET //9
//    @Path("/getRoleByName/{name}")
//    @Produces(MediaType.APPLICATION_JSON)
//    @PermitAll
////    @RolesAllowed({"ADMIN", "Employee"})
//    public Response getRoleByName(
//            @DefaultValue("Daniyal")
//            @PathParam("name") String name){
//        return Response.ok().entity(roleService.getRoleByName(name)).build();
//    }
//
//    @GET //10
//    @Path("/getUserdetailsById/{Id}")
//    @Produces(MediaType.APPLICATION_JSON)
//    @PermitAll
////    @RolesAllowed({"ADMIN", "Employee"})
//    public Response getUserdetailsByName(
//            @DefaultValue("0")
//            @PathParam("Id") Long id){
//        return Response.ok().entity(userdetailService.getUserdetailById(id)).build();
//    }
//
//    @GET //11
//    @Path("/getUserdetailsByName/{name}")
//    @Produces(MediaType.APPLICATION_JSON)
//    @PermitAll
////    @RolesAllowed({"ADMIN", "Employee"})
//    public Response getUserdetailsByName(
//            @DefaultValue("Dan")
//            @PathParam("name") String name){
//        return Response.ok().entity(userdetailService.getUserdetailByName(name)).build();
//    }
//
//    @GET //12
//    @Path("/getItemById/{Id}")
//    @Produces(MediaType.APPLICATION_JSON)
//    @PermitAll
////    @RolesAllowed({"ADMIN", "Employee"})
//    public Response getItemByName(
//            @DefaultValue("0")
//            @PathParam("Id") Long id){
//        return Response.ok().entity(itemService.getItemById(id)).build();
//    }
//
//    @GET //13
//    @Path("/getItemByName/{name}")
//    @Produces(MediaType.APPLICATION_JSON)
//    @PermitAll
////    @RolesAllowed({"ADMIN", "Employee"})
//    public Response getItemByName(
//            @DefaultValue("Dan")
//            @PathParam("name") String name){
//        return Response.ok().entity(itemService.getItemByName(name)).build();
//    }
//
//
//    @GET //14
//    @Path("/getItemByPrice/{price}")
//    @Produces(MediaType.APPLICATION_JSON)
//    @PermitAll
////    @RolesAllowed({"ADMIN", "Employee"})
//    public Response getItemByPrice(
//            @DefaultValue("0")
//            @PathParam("price") Double price){
//        return Response.ok().entity(itemService.getItemByPrice(price)).build();
//    }
//
//    @GET //15
//    @Path("/getGoodByPrice/{price}")
//    @Produces(MediaType.APPLICATION_JSON)
//    @PermitAll
////    @RolesAllowed({"ADMIN", "Employee"})
//    public Response getGoodByPrice(
//            @DefaultValue("0")
//            @PathParam("price") Double price){
//        return Response.ok().entity(goodService.getGoodByPrice(price)).build();
//    }
//
//    @GET //16
//    @Path("/getGoodByName/{name}")
//    @Produces(MediaType.APPLICATION_JSON)
//    @PermitAll
////    @RolesAllowed({"ADMIN", "Employee"})
//    public Response getGoodByPrice(
//            @DefaultValue("Dan")
//            @PathParam("name") String name){
//        return Response.ok().entity(goodService.getGoodByName(name)).build();
//    }
//
//    @GET //17
//    @Path("/getGoodById/{id}")
//    @Produces(MediaType.APPLICATION_JSON)
//    @PermitAll
////    @RolesAllowed({"ADMIN", "Employee"})
//    public Response getGoodById(
//            @DefaultValue("0")
//            @PathParam("id") Long id){
//        return Response.ok().entity(goodService.getGoodById(id)).build();
//    }
//
//    @GET //18
//    @Path("/getCostById/{id}")
//    @Produces(MediaType.APPLICATION_JSON)
//    @PermitAll
////    @RolesAllowed({"ADMIN", "Employee"})
//    public Response getCostById(
//            @DefaultValue("0")
//            @PathParam("id") int id){
//        return Response.ok().entity(costService.getCostById(id)).build();
//    }
//
//    @GET //19
//    @Path("/getCommentById/{id}")
//    @Produces(MediaType.APPLICATION_JSON)
//    @PermitAll
////    @RolesAllowed({"ADMIN", "Employee"})
//    public Response getCommentById(
//            @DefaultValue("0")
//            @PathParam("id") int id){
//        return Response.ok().entity(commentService.getCommentById(id)).build();
//    }

//    @DELETE
//    @Path("/deleteUser/{Id}")   /////////Works
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response deleteUser(
//            @DefaultValue("0")
//            @PathParam("Id") int id){
//        userService.deleteUser(id);
//        return Response.ok().entity("User has been deleted").build();
//    }
//
//    @DELETE
//    @Path("/deleteUserdetail/{Id}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response deleteUserdetail(
//            @DefaultValue("0")
//            @PathParam("Id") int id){
//        userdetailService.deleteByid(id);
//        return Response.ok().entity("Userdetails has been deleted").build();
//    }
//
//    @DELETE
//    @Path("/deleteItem/{Id}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response deleteItem(
//            @DefaultValue("0")
//            @PathParam("Id") int id){
//        itemService.deleteItemById(id);
//        return Response.ok().entity("Items has been deleted").build();
//    }
//
//    @DELETE
//    @Path("/deleteGood/{Id}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response deleteGood(
//            @DefaultValue("0")
//            @PathParam("Id") int id){
//        goodService.deleteGoodById(id);
//        return Response.ok().entity("Good has been deleted").build();
//    }
//
//    @DELETE
//    @Path("/deleteCost/{Id}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response deleteCost(
//            @DefaultValue("0")
//            @PathParam("Id") int id){
//        costService.deleteCostById(id);
//        return Response.ok().entity("Cost has been deleted").build();
//    }
//
//    @DELETE
//    @Path("/deleteComment/{Id}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response deleteComment(
//            @DefaultValue("0")
//            @PathParam("Id") int id){
//        commentService.deleteCommentById(id);
//        return Response.ok().entity("Comment has been deleted").build();
//    }
//
//
//    @POST
//    @Path("/createUser")   /////Works
//    @Produces(MediaType.APPLICATION_JSON)
//    @Consumes(MediaType.APPLICATION_JSON)
//    @PermitAll
////    @RolesAllowed({"admin", "dealer"})
//    public User createUser(User user) {
//        userService.createUser(user.getLogin(), user.getPassword());
//        return user;
//    }

//    @POST
//    @Path("/createItem")
//    @Produces(MediaType.APPLICATION_JSON)
//    @Consumes(MediaType.APPLICATION_JSON)
//    @PermitAll
////    @RolesAllowed({"admin", "dealer"})
//    public Item createItem(Item item) {
//        itemService.createItem(item.getName(), item.getPrice());
//        return item;
//    }
//
//    @POST
//    @Path("/createGood")
//    @Produces(MediaType.APPLICATION_JSON)
//    @Consumes(MediaType.APPLICATION_JSON)
//    @PermitAll
////    @RolesAllowed({"admin", "dealer"})
//    public Good createGood(Good good) {
//        goodService.createGood(good.getName(), good.getPrice());
//        return good;
//    }

//    @POST
//    @Path("/createCost")
//    @Produces(MediaType.APPLICATION_JSON)
//    @Consumes(MediaType.APPLICATION_JSON)
//    @PermitAll
////    @RolesAllowed({"admin", "dealer"})
//    public Cost createCost(Cost cost) {
//        costService.createCost(cost.getId(), cost.getCost(), cost.getDescription());
//        return cost;
//    }

//    @POST
//    @Path("/createComment")
//    @Produces(MediaType.APPLICATION_JSON)
//    @Consumes(MediaType.APPLICATION_JSON)
//    @PermitAll
////    @RolesAllowed({"admin", "dealer"})
//    public Comment createComment(Comment comment) {
//        commentService.createComment(comment.getComment());
//        return comment;
//    }

}