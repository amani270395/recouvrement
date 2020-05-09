package com.amani.backend.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class FactureAvoir {
	
	@Id
	@NotNull
	@NotEmpty
	private Long num;
	
	@NotNull
	@NotEmpty
	private Long montant;
	
	@NotNull
	@NotEmpty
	private int annee;
	
	@NotNull
	@NotEmpty
	private String dateAvoir;
	
	@NotNull
	@NotEmpty
	private String observation;
	
	@ManyToOne
	@JoinColumn(name = "numFacture" )
	private Facture facture;

	public Long getNum() {
		return num;
	}

	public void setNum(Long num) {
		this.num = num;
	}

	public Long getMontant() {
		return montant;
	}

	public void setMontant(Long montant) {
		this.montant = montant;
	}

	public int getAnnee() {
		return annee;
	}

	public void setAnnee(int annee) {
		this.annee = annee;
	}

	public String getDateAvoir() {
		return dateAvoir;
	}

	public void setDateAvoir(String dateAvoir) {
		this.dateAvoir = dateAvoir;
	}

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

	public Facture getFacture() {
		return facture;
	}

	public void setFacture(Facture facture) {
		this.facture = facture;
	}
	
	

}
