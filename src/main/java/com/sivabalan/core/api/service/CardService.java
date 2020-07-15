package com.sivabalan.core.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sivabalan.core.api.entity.Card;
import com.sivabalan.core.api.model.AddCardRequest;
import com.sivabalan.core.api.repository.CardRepository;

@Service
public class CardService {
	
	@Autowired
	private CardRepository cardRepository;
	
	public List<Card> addCard(AddCardRequest addCardRequest){
		Card card = new Card();
		card.setTitle(addCardRequest.getTitle());
		card.setStatus(addCardRequest.getStatus());
		return cardRepository.addCard(card);
	}

	public List<Card> toProgress(String id) {
		// TODO Auto-generated method stub
		return cardRepository.toProgress(id);
	}
	
	public List<Card> toDone(String id) {
		// TODO Auto-generated method stub
		return cardRepository.toDone(id);
	}

	public List<Card> toDo(String id) {
		// TODO Auto-generated method stub
		return cardRepository.toDo(id);
	}

	public List<Card> listAll() {
		// TODO Auto-generated method stub
		return cardRepository.listAll();
	}

	public List<Card> updateTitle(String id, String title) {
		// TODO Auto-generated method stub
		return cardRepository.updateTitle(id, title);
	}
}
