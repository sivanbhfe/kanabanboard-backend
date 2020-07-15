package com.sivabalan.core.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sivabalan.core.api.entity.Card;
import com.sivabalan.core.api.model.AddCardRequest;
import com.sivabalan.core.api.model.UpdateTitle;
import com.sivabalan.core.api.service.CardService;

@RestController
public class CardController {
	
	@Autowired
	private CardService cardService;

	
	@CrossOrigin
	@PostMapping(value="addcard", consumes= {MediaType.APPLICATION_JSON_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<Card> addCard(@RequestBody AddCardRequest addcardRequest) {
		return cardService.addCard(addcardRequest);
	}
	
	@CrossOrigin
	@GetMapping(value="toprogress/{id}", consumes= {MediaType.APPLICATION_JSON_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<Card> toProgress(@PathVariable String id) {
		return cardService.toProgress(id);
	}
	
	@CrossOrigin
	@GetMapping(value="todone/{id}", consumes= {MediaType.APPLICATION_JSON_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<Card> toDone(@PathVariable String id) {
		return cardService.toDone(id);
	}
	@CrossOrigin
	@GetMapping(value="todo/{id}", consumes= {MediaType.APPLICATION_JSON_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<Card> toDo(@PathVariable String id) {
		return cardService.toDo(id);
	}
	@CrossOrigin
	@PostMapping(value="updatetitle", consumes= {MediaType.APPLICATION_JSON_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<Card> updateTitle(@RequestBody UpdateTitle updateTitle) {
		System.out.println(updateTitle.getTitle());
		return cardService.updateTitle(updateTitle.getId(),updateTitle.getTitle());
	}
	@CrossOrigin
	@GetMapping(value="listall", consumes= {MediaType.APPLICATION_JSON_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<Card> listAll() {
		return cardService.listAll();
	}

}
