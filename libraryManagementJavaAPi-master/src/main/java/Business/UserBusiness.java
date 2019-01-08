package Business;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import model.Book;
import model.User;
import repositories.BookRepository;
import repositories.UserRepository;

@Component
public class UserBusiness {
	@Inject
	UserRepository userRepository;
	@Inject
	BookRepository bookRepository;

	@Transactional
	public User createUser(User input) {
		input.setFavouritesBooks(new ArrayList<Book>());
		if (userRepository.getAll() != null) {
			for (User item : userRepository.getAll()) {
				if (item.getEmail().contentEquals(input.getEmail())) {
					return null;
				}
			}
		}

		return userRepository.save(input);
	}

	public User getUser(long userId) {
		User temp = searchUserById(userId);
		if (temp != null) {
			return temp;
		} else {
			return null;
		}
	}

	@Transactional
	public void changeUserActiveState(long userId, boolean newUserState) {
		User user = userRepository.findById(userId);
		user.setActive(newUserState);
		userRepository.update(user);
	}

	/**
	 * Update de todos os parametrosdo utilizador
	 * 
	 * @param input
	 * @return
	 */

	@Transactional
	public User updateUser(User input) {
		return userRepository.update(input);
	}

	/**
	 * Pesquisa todos os utilizadores
	 * 
	 * @return uma lista com todos os utilizadores
	 */

	public List<User> getAll() {
		return userRepository.getAll();
	}

	/**
	 * Pesquisa utilizadoresporId
	 * 
	 * @param userId
	 * @return utilizador
	 */

	public User searchUserById(long userId) {
		User temp = userRepository.findById(userId);
		return temp;
	}

	/**
	 * Pesquisa de utilizadores por nome
	 * 
	 * @param name
	 * @return List de userDto com esse nome
	 */

	public List<User> searchUserByName(String name) {
		List<User> allUsers = userRepository.getAll();
		List<User> listToBeReturned = new ArrayList<User>();
		for (User userInit : allUsers) {
			String name2 = userInit.getName();
			if (name2.equalsIgnoreCase(name)) {
				listToBeReturned.add(userInit);
			}
		}
		return listToBeReturned;
	}

	/**
	 * Pesquisa de utilizadores por NIP
	 * 
	 * @param nip
	 * @return List de userDto que contenham nip
	 */
	public List<User> searchUserByNip(String nip) {
		List<User> allUsers = userRepository.getAll();
		List<User> listToBeReturned = new ArrayList<User>();
		for (User userInit : allUsers) {
			String nip2 = userInit.getNip();
			if (nip2.equalsIgnoreCase(nip)) {
				listToBeReturned.add(userInit);
			}
		}
		return listToBeReturned;
	}

	/**
	 * 
	 * @param email
	 * @return List de userDto que contenham email
	 */
	public List<User> searchUserByEmail(String email) {
		List<User> allUsers = userRepository.getAll();
		List<User> listToBeReturned = new ArrayList<User>();
		for (User userInit : allUsers) {
			String email2 = userInit.getEmail();
			if (email2.equalsIgnoreCase(email)) {
				listToBeReturned.add(userInit);
			}
		}
		return listToBeReturned;
	}

	@Transactional
	public boolean isUserActive(long userIdToTest) {
		User userToTest = userRepository.findById(userIdToTest);
		if (userToTest.isActive()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Transforma utilizador em Administrador
	 * 
	 * @param id
	 * @return UserDTo
	 */

	@Transactional
	public User turnUserToAdmin(long id) {
		if (isUserActive(id)) {
			User temp = searchUserById(id);
			temp.setAdmin(true);
			userRepository.update(temp);
			return userRepository.findById(id);
		}
		return null;
	}

	@Transactional
	public List<Book> addBookToFavourites(long idUser, long idBook) {
		User user = userRepository.findById(idUser);
		Book book = bookRepository.findById(idBook);
		if (!isfavourite(idBook, user.getFavouritesBooks())) {
			user.getFavouritesBooks().add(book);
			userRepository.update(user);
			return (user.getFavouritesBooks());
		}
		return null;

	}

	@Transactional
	public boolean isfavourite(long idBook, List<Book> favouritesList) {
		for (Book item : favouritesList) {
			if (idBook == item.getId())
				return true;
		}
		return false;
	}

	public List<Book> getAllFavourites(long idUser) {
		return userRepository.findById(idUser).getFavouritesBooks();
	}

	@Transactional
	public List<Book> removeFavourite(long idUser, long idBook) {
		User user = userRepository.findById(idUser);
		Book book = bookRepository.findById(idBook);
		if (isfavourite(idBook, user.getFavouritesBooks())) {
			user.getFavouritesBooks().remove(book);
			userRepository.update(user);
			return userRepository.findById(idUser).getFavouritesBooks();
		}
		return null;
	}

	public User loginUser(String userEmail, String userPassword) {
		for (User item : userRepository.getAll()) {
			if (item.getEmail() != null && item.getPassword() != null) {
				if (item.getEmail().equals(userEmail) && item.getPassword().equals(userPassword)) {
					return item;
				}
			}

		}
		return null;
	}
@Transactional
	public User changeUserPassword(long userId, String newPassword) {
		User userToChange = userRepository.findById(userId);
		userToChange.setPassword(newPassword);
		return userRepository.update(userToChange);
	}
}
