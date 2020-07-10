package com.sivabalan.core.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sivabalan.core.api.entity.Card;
import com.sivabalan.core.api.model.AddCardRequest;
import com.sivabalan.core.api.repository.CardRepository;

@Service
public class CardService {
	
	@Autowired
	private CardRepository cardRepository;
	
	public void addCard(AddCardRequest addCardRequest){
		Card card = new Card();
		card.setTitle(addCardRequest.getTitle());
		card.setStatus(addCardRequest.getStatus());
		cardRepository.addCard(card);
	}

}
