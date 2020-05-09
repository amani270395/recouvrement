package com.amani.backend.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Paiement {
	@Id
	@NotNull
	@NotEmpty
	private Long idPaiement;
	
	@NotNull
	@NotEmpty
	private String datePaiement;
	
	@NotNull
	@NotEmpty
	private String dateAction;
	
	@NotNull
	@NotEmpty
	private String montant;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "numFacture")
	private Facture facture;

	public String getDatePaiement() {
		return datePaiement;
	}

	public void setDatePaiement(String datePaiement) {
		this.datePaiement = datePaiement;
	}

	public String getDateAction() {
		return dateAction;
	}

	public void setDateAction(String dateAction) {
		this.dateAction = dateAction;
	}

	public String getMontant() {
		return montant;
	}

	public void setMontant(String montant) {
		this.montant = montant;
	}

	public Long getIdPaiement() {
		return idPaiement;
	}

	public void setIdPaiement(Long idPaiement) {
		this.idPaiement = idPaiement;
	}

	public Facture getFacture() {
		return facture;
	}

	public void setFacture(Facture facture) {
		this.facture = facture;
	}
	
	
	

}
