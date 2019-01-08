package repositories;

import org.springframework.stereotype.Repository;

import model.User;

@Repository
public class UserRepository extends EntityRepository <User>{

	private UserRepository() {
	}
	
		
	@Override
	protected Class<User> getEntityClass() {
		return User.class;
	}


	@Override
	protected String getAllEntityQueryName() {
		return "getAllUsers";
	}

	
}
