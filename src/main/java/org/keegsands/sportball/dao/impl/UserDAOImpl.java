package org.keegsands.sportball.dao.impl;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.keegsands.sportball.dao.UserDAO;
import org.keegsands.sportball.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.transaction.Transactional;
import java.util.List;

public class UserDAOImpl extends AbstractSimpleDAOImpl<User> implements UserDAO {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserDAOImpl.class);
	private static final String FROM_CLAUSE = "from User ORDER by name ASC";

	private static final Class<User> TYPE = User.class;

	@Override
	protected Logger getLogger() {
		return LOGGER;
	}

	@Override
	String getFromClause() {
		return FROM_CLAUSE;
	}

	@Override
	protected Class<User> getType() {
		return TYPE;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public User findUserByUsername(String username) {
		LOGGER.info("Looking up user information for: " + username);
		final Session session = super.getSession();
		final Query query = session.createQuery("from User WHERE username= :theUserName");
		query.setParameter("theUserName", username);
		query.setMaxResults(1);
		final List<User> list = query.list();
		if (list == null || list.size() < 1) {
			// If no user found just return an empty user, which will always
			// fail credentials
			return new User();
		} else {
			return list.get(0);
		}
	}

}
