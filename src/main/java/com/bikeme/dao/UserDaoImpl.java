package com.bikeme.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bikeme.model.User;

@Repository
public class UserDaoImpl implements UserDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public User save(User person) {
		if (person.getId() == null) {
			entityManager.persist(person);
			return person;
		} else {
			return entityManager.merge(person);
		}
	}

	public boolean checkUser(String username, String password) {

		Query query = entityManager.createQuery("from User where username = :username and password = :password");
		query.setParameter("username", username);
		query.setParameter("password", password);

		return !query.getResultList().isEmpty();
	}

}
