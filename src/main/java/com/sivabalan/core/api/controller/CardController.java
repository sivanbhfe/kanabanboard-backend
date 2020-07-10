package com.sivabalan.core.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sivabalan.core.api.model.AddCardRequest;
import com.sivabalan.core.api.service.CardService;

@RestController
public class CardController {
	
	@Autowired
	private CardService cardService;

	
	@CrossOrigin
	@PostMapping(value="addcard", consumes= {MediaType.APPLICATION_JSON_VALUE})
	public String addCard(@RequestBody AddCardRequest addcardRequest) {
		
		cardService.addCard(addcardRequest);
		return "success";
	}

}
