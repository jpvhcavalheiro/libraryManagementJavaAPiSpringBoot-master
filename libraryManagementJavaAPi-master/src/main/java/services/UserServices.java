package services;

import java.util.List;

import javax.inject.Inject;
import javax.validation.constraints.NotNull;
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

import org.springframework.stereotype.Component;

import Business.UserBusiness;
import model.Book;
import model.User;

@Component
@Path("/users")
public class UserServices {
	@Inject 
	UserBusiness userBusiness;
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public User createUser(User input){
		return userBusiness.createUser(input);
	}
	
	@GET
	@Path("/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public User getUser(@PathParam("userId") long userId) {
		return userBusiness.getUser(userId);
	}
	
	@PUT
	@Path("/disable/{userId}")
	@Produces(MediaType.TEXT_PLAIN)
	public String disableUser(@PathParam("userId") long userId) {
		userBusiness.changeUserActiveState(userId,false);
		return "utilizador inactivo";
	}
	
	@PUT
	@Path("/reactivateuser/{userId}")
	@Produces(MediaType.TEXT_PLAIN)
	public String reactivateUser(@PathParam("userId") long userId) {
		userBusiness.changeUserActiveState(userId,true);
		return "utilizador activo";
	}
	
	@PUT
	@Path("/update/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public User updateUser(User input) {
		return userBusiness.updateUser(input);
	}

	@GET
	@Path("/getall")
	@Produces(MediaType.APPLICATION_JSON)
	public  List<User> getAllUsers(){
		return userBusiness.getAll();
	}
	
	@GET
	@Path("/findby/name")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public  List<User> searchUserByName(String name){
		return userBusiness.searchUserByName(name);
	}
	
	@GET
	@Path("/findby/nip")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public  List<User> searchUserByNip(String nip){
		return userBusiness.searchUserByNip(nip);
	}
	
	@GET
	@Path("/findby/email")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public  List<User> searchUserByEmail(String email){
		return userBusiness.searchUserByEmail(email);
	}
	
	@PUT
	@Path("/changetoadmin/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public  User turnUserToAdmin(@PathParam("userId") long userId){
		return userBusiness.turnUserToAdmin(userId);
	}
	
	@POST
	@Path("/addfavourite/")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Book> addBookToFavourites(@NotNull @QueryParam("userId") long userId, @NotNull @QueryParam("bookId") long bookId){
		return userBusiness.addBookToFavourites(userId, bookId);
	}
	
	@GET
	@Path("/getallfavourites/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public  List<Book>  getAllFavourites(@PathParam("userId") long userId){
		return userBusiness.getAllFavourites(userId);
	}
	
	@DELETE
	@Path("/removefavourite/")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Book> removeFavourite(@NotNull @QueryParam("userId") long userId, @NotNull @QueryParam("bookId") long bookId){
		return userBusiness.removeFavourite(userId, bookId);
	}
	
	@GET
	@Path("/loginuser")
	@Produces(MediaType.APPLICATION_JSON)
	public User loginUser(@NotNull @QueryParam("userEmail") String userEmail,@NotNull @QueryParam("userPassword") String userPassword){
		return userBusiness.loginUser(userEmail,userPassword);
	}
	
	@PUT
	@Path("/changepassword/{userId}")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public  User changeUserPassword(@PathParam("userId") long userId,String newPassword){
		return userBusiness.changeUserPassword(userId, newPassword);
	}
	
	
}