package com.microservices.elit.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the demande database table.
 * 
 */
@Entity
@NamedQuery(name="Demande.findAll", query="SELECT d FROM Demande d")
public class Demande implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String etat;

	private String objet;

	private String type;

	public Demande() {
	}

	public Demande(int id2, String string) {
		// TODO Auto-generated constructor stub
		this.id=id2;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEtat() {
		return this.etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public String getObjet() {
		return this.objet;
	}

	public void setObjet(String objet) {
		this.objet = objet;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

}