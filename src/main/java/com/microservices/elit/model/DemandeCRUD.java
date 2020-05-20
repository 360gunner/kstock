package com.microservices.elit.model;

public class DemandeCRUD {
	
	Demande test;
	
	HTTPTYPE type;
	
	public DemandeCRUD() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DemandeCRUD(Demande test, HTTPTYPE type) {
		super();
		this.test = test;
		this.type = type;
	}

	public Demande getDemande() {
		return test;
	}

	public void setDemande(Demande test) {
		this.test = test;
	}

	public HTTPTYPE getType() {
		return type;
	}

	public void setType(HTTPTYPE type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "DemandeCRUD [this=" + test + ", type=" + type + "]";
	}
	
}