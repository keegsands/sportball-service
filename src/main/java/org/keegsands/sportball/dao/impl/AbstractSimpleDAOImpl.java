package org.keegsands.sportball.dao.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.keegsands.sportball.dao.SimpleDAO;
import org.slf4j.Logger;

import java.util.List;

public abstract class AbstractSimpleDAOImpl<G> implements SimpleDAO<G> {

	@PersistenceContext
	private EntityManager entityManager;

	abstract protected Logger getLogger();

	abstract String getFromClause();

	abstract protected Class<G> getType();

	protected Session getSession(){
		return entityManager.unwrap(Session.class);
	}


	public void add(G p) {
		final Session session = getSession();
		session.persist(p);
		getLogger().info("Entity saved successfully, Entity Details=" + p);
	}

	public void update(G p) {
		final Session session = getSession();
		session.update(p);
		getLogger().info("Entity updated successfully, Entity Details=" + p);

	}

	@SuppressWarnings("unchecked")
	public List<G> list() {
		final Session session = getSession();
		final List<G> list = session.createQuery(getFromClause()).list();
		for (final G p : list) {
			getLogger().info("Team List::" + p);
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	public G getById(int id) {
		final Session session = getSession();
		final G p = (G) session.get(getType(), Integer.valueOf(id));
		getLogger().info("Entity loaded successfully, Entity details=" + p);
		return p;
	}

	@SuppressWarnings("unchecked")
	public void remove(int id) {
		final Session session = getSession();
		final G p = (G) session.load(getType(), Integer.valueOf(id));
		if (null != p) {
			session.delete(p);
		}
		getLogger().info("Entity deleted successfully, Entity details=" + p);

	}

}
