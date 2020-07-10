package com.sivabalan.core.api.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sivabalan.core.api.model.AddCardRequest;
import com.sivabalan.core.api.model.AddCardResponse;

@RestController
public class CardController {
	
	@CrossOrigin
	@PostMapping(value="addcard", consumes= {MediaType.APPLICATION_JSON_VALUE})
	public AddCardResponse addCard(@RequestBody AddCardRequest addcardRequest) {
		
		AddCardResponse addCardResponse = new AddCardResponse();
		addCardResponse.setId(addcardRequest.getId());
		addCardResponse.setStatus(addcardRequest.getStatus());
		addCardResponse.setTitle(addcardRequest.getStatus());
		return addCardResponse;
	}

}
