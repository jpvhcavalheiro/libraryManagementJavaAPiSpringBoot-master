package Business;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import model.Book;
import model.User;
import repositories.BookRepository;
import repositories.HistoryRepository;
import repositories.UserRepository;

@Component
public class BookBusiness {
	@Inject
	BookRepository bookRepository;
	@Inject
	UserRepository userRepository;
	@Inject
	HistoryBusiness historyBusiness;

	@Transactional
	public Book createBook(Book bookToCreate) {
		bookToCreate.setState("available");
		return bookRepository.save(bookToCreate);
	}

	public Book getABook(long bookIdToGet) {
		if (bookRepository.findById(bookIdToGet) != null) {
			return bookRepository.findById(bookIdToGet);
		} else {
			return null;
		}
	}

	public ArrayList<Book> seeAllBooks() {
		ArrayList<Book> bookRepository1 = new ArrayList<Book>();
		for (Book item : bookRepository.getAll()) {
			bookRepository1.add(item);
		}
		return bookRepository1;
	}

	@Transactional
	public String removeBook(long bookIdToRemove) {
		if (bookRepository.findById(bookIdToRemove) != null) {
			Book bookToRemove = bookRepository.findById(bookIdToRemove);
			bookRepository.removeById(bookIdToRemove);

			return "Book removed successfully";
		}
		return null;
	}

	public ArrayList<Book> generalResearchForBook(String keyExpression) {
		ArrayList<Book> resultToKeyExpression = new ArrayList<Book>();
		for (Book item : bookRepository.getAll()) {
			if (matchStringToSubstring(item.getTitle(), keyExpression)
					|| matchStringToSubstring(item.getDescription(), keyExpression)
					|| matchStringToSubstring(item.getAuthor(), keyExpression)
					|| matchStringToSubstring(item.getTopic(), keyExpression)
					|| matchStringToSubstring(item.getIsbn(), keyExpression)) {
				resultToKeyExpression.add(item);
			}
		}
		return resultToKeyExpression;
	}

	/**
	 * função insensível a maiúculas e minúsculas que returna se uma superstring
	 * contem uma substring
	 * 
	 * @param Superstring
	 *            - string que se quer verificar se contem a substring
	 * @param substring
	 *            - string que se quer verificar se está contida na superstring
	 * @return - true se superstring contiver substring e falso caso contrário
	 * 
	 */
	public boolean matchStringToSubstring(String Superstring, String substring) {
		System.out.println(Superstring);
		if (Superstring != null && substring != null) {
			if (Superstring.toLowerCase().contains(substring.toLowerCase())) {
				return true;
			}
		}
		return false;
	}

	@Transactional
	public Book updateBook(Book updatedBook) {
		if (bookRepository.findById(updatedBook.getId()) != null) {
			Book outdatedBook = bookRepository.findById(updatedBook.getId());
			return bookRepository.update(updatedBook);
		} else {
			return null;
		}

	}

	public ArrayList<Book> researchBookByTitle(String titleToTest) {
		ArrayList<Book> resultToTitleToTest = new ArrayList<Book>();
		for (Book item : bookRepository.getAll()) {
			if (matchStringToSubstring(item.getTitle(), titleToTest)) {
				resultToTitleToTest.add(item);
			}
		}
		return resultToTitleToTest;
	}

	public ArrayList<Book> researchBookByDescription(String bookDescriptionToTest) {
		ArrayList<Book> resultToDescriptionToTest = new ArrayList<Book>();
		for (Book item : bookRepository.getAll()) {
			if (matchStringToSubstring(item.getDescription(), bookDescriptionToTest)) {
				resultToDescriptionToTest.add(item);
			}
		}
		return resultToDescriptionToTest;
	}

	public ArrayList<Book> researchBookByAuthor(String authorToTest) {
		ArrayList<Book> resultToAuthorToTest = new ArrayList<Book>();
		for (Book item : bookRepository.getAll()) {
			if (matchStringToSubstring(item.getAuthor(), authorToTest)) {
				resultToAuthorToTest.add(item);
			}
		}
		return resultToAuthorToTest;
	}

	public ArrayList<Book> researchBookByTopic(String topicToTest) {
		ArrayList<Book> resultToTopicToTest = new ArrayList<Book>();
		for (Book item : bookRepository.getAll()) {
			if (matchStringToSubstring(item.getTopic(), topicToTest)) {
				resultToTopicToTest.add(item);
			}
		}
		return resultToTopicToTest;
	}
	
	public ArrayList<Book> getAllAvailableBooks(){
		ArrayList<Book> resultToAvailableBooks = new ArrayList<Book>();
		for(Book item:bookRepository.getAll()) {
			if(item.getState().equals("available")) {
				resultToAvailableBooks.add(item);
			}
		}
		return resultToAvailableBooks;
	}
}
