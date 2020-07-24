package com.sivabalan.core.api.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="kanbancardtable")
@NamedQueries(
		{
			@NamedQuery(name = "retrieveallcards", query = "select a from Card a order by a.id ASC"),
			@NamedQuery(name = "getcardbyid", query = "select a from Card a where a.id=:id")
		}
		)
public class Card {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private String title;
	private String status;
	public int getId() {
		return id;
	}

	public String getTitle () {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

}
