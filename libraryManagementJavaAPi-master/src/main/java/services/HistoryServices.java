package services;



import java.util.ArrayList;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Component;

import Business.HistoryBusiness;
import model.Book;
import model.History;
import model.User;

@Component
@Path("/historys")
public class HistoryServices {
	@Inject
	HistoryBusiness historyBusiness;
	
	
	@POST
	@Path("/reservebook")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public History reserveBookHistory(History newHistory){
		return historyBusiness.reserveBookHistory(newHistory);
	}
	
	@PUT
	@Path("/pickupbook")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public History pickUpBook(Book bookToPickUp){
		return historyBusiness.pickUpBook(bookToPickUp);
	}
	
	@PUT
	@Path("/deliverbook")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public History deliverBook(Book bookToDeliver){
		return historyBusiness.deliverBook(bookToDeliver);
	}
	
	@GET
	@Path("/getuserwithbook/{idBook}")
	@Produces(MediaType.APPLICATION_JSON)
	public User getUserWithBook(@PathParam("idBook") long idBook){
		return historyBusiness.getUserWithBook(idBook);
	}
	
	@GET
	@Path("/bookinusebyuser/{idUser}")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Book> getBooksWithUser(@PathParam("idUser") long idUser){
		return historyBusiness.getBooksWithUser(idUser);
	}
	
	@GET
	@Path("/userhistory/{idUser}")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<History> getAllHstoryOfUser(@PathParam("idUser") long idUser){
		return historyBusiness.getAllHstoryOfUser(idUser);
	}
	
}
