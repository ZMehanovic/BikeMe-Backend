package com.bikeme.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.bikeme.model.User;

@Repository
public class UserDaoImpl implements UserDao {

	@PersistenceContext
	private EntityManager entityManager;

	public boolean checkUser(String username, String password) {

		Query query = entityManager.createQuery("from User where username = :username and password = :password");
		query.setParameter("username", username);
		query.setParameter("password", password);

		return !query.getResultList().isEmpty();
	}

	public boolean createUser(User user) {
		boolean result = true;
		Session session = ((Session) entityManager.getDelegate()).getSessionFactory().openSession();
		try {
			Transaction tx = session.beginTransaction();
			session.save(user);
			tx.commit();
		} catch (Exception e) {
			System.out.println(e);
			result = false;
		} finally {
			session.close();
		}

		return result;
	}

}
