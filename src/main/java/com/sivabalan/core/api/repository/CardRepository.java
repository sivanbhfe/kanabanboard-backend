package com.sivabalan.core.api.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.sivabalan.core.api.entity.Card;

@Repository
public class CardRepository {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional
	public void addCard(Card card) {	
		entityManager.persist(card);
				
	}
	

}
