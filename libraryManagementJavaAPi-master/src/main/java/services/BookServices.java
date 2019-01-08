package services;

import java.util.ArrayList;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Component;

import Business.BookBusiness;
import model.Book;

@Component
@Path("/books")
public class BookServices {

	@Inject
	BookBusiness bookBusiness;
	
	
	@GET
	@Path("/verify")
	@Produces(MediaType.TEXT_PLAIN)
	public String verify(){
		return "Server books OK!";
	}
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Book createBook(Book bookToSave){
		return bookBusiness.createBook(bookToSave);
	}
	@ GET
	@ Path("/{id}")
	@ Produces(MediaType.APPLICATION_JSON)
	public Book getABook(@PathParam("id") long id){
		return bookBusiness.getABook(id);
	}
	
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Book> seeAllBooks(){
		return bookBusiness.seeAllBooks();
	}
	
	@DELETE
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String removeBook(@PathParam("id") long id){
		return bookBusiness.removeBook(id);
	}
	
	@PUT
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Book updateBook(Book updatedBook){
		
		return bookBusiness.updateBook(updatedBook);
	}
	
	@GET
	@Path("/generalresearch")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Book> generalResearchForBook(String keyExpression){
		return bookBusiness.generalResearchForBook(keyExpression);
	}
	
	@GET
	@Path("/researchbytitle")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Book> researchBookByTitle(String titleToTest){
		return bookBusiness.researchBookByTitle(titleToTest);
	}
	
	@GET
	@Path("/researchbydescription")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Book> researchBookByDescription(String descriptionToTest){
		return bookBusiness.researchBookByDescription(descriptionToTest);
	}
	
	@GET
	@Path("/researchbyauthor")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Book> researchBookByAuthor(String authorToTest){
		return bookBusiness.researchBookByAuthor(authorToTest);
	}
	
	@GET
	@Path("/researchbytopic")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Book> researchBookByTopic(String topicToTest){
		return bookBusiness.researchBookByTopic(topicToTest);
	}
	
	@GET
	@Path("/getallavailablebooks")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Book> getAllAvailableBooks(){
		return bookBusiness.getAllAvailableBooks();
	}
	
	
}
