package repositories;


import org.springframework.stereotype.Repository;

import model.History;

@Repository
public class HistoryRepository extends EntityRepository<History>{
	
	private HistoryRepository() {
	}
	
	
	@Override
	protected Class<History> getEntityClass() {
		return History.class;
	}

	@Override
	protected String getAllEntityQueryName() {
		return History.GET_ALL_HISTORYS_QUERY_NAME;
	}

}
