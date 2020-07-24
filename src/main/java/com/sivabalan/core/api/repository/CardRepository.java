package com.sivabalan.core.api.repository;

import java.util.List;

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
	public List<Card> addCard(Card card) {	
		entityManager.persist(card);
		return this.entityManager.createNamedQuery("retrieveallcards").getResultList();
	}

	@Transactional
	public List<Card> toProgress(String cardid) {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(cardid);
		Card temp = (Card) this.entityManager.createNamedQuery("getcardbyid").setParameter("id", id).getSingleResult();
		temp.setStatus("inprogress");
		this.entityManager.merge(temp);
		return this.entityManager.createNamedQuery("retrieveallcards").getResultList();
	}
	
	@Transactional
	public List<Card> toDone(String cardid) {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(cardid);
		Card temp = (Card) this.entityManager.createNamedQuery("getcardbyid").setParameter("id", id).getSingleResult();
		temp.setStatus("done");
		this.entityManager.merge(temp);
		return this.entityManager.createNamedQuery("retrieveallcards").getResultList();
	}
	
	@Transactional
	public List<Card> toDo(String cardid) {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(cardid);
		Card temp = (Card) this.entityManager.createNamedQuery("getcardbyid").setParameter("id", id).getSingleResult();
		temp.setStatus("todo");
		this.entityManager.merge(temp);
		return this.entityManager.createNamedQuery("retrieveallcards").getResultList();
	}

	public List<Card> listAll() {
		// TODO Auto-generated method stub
		return this.entityManager.createNamedQuery("retrieveallcards").getResultList();
	}

	@Transactional
	public List<Card> updateTitle(String cardid, String title) {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(cardid);
		Card temp = (Card) this.entityManager.createNamedQuery("getcardbyid").setParameter("id", id).getSingleResult();
		temp.setTitle(title);
		System.out.println(title);
		System.out.println(cardid);
		this.entityManager.merge(temp);
		return this.entityManager.createNamedQuery("retrieveallcards").getResultList();
	}

	@Transactional
	public List<Card> deleteCard(String cardid) {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(cardid);
		Card temp = (Card) this.entityManager.createNamedQuery("getcardbyid").setParameter("id", id).getSingleResult();
		this.entityManager.remove(temp);
		return this.entityManager.createNamedQuery("retrieveallcards").getResultList();	
	}
}
