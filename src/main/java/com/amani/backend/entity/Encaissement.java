package com.amani.backend.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Encaissement {
	
	@Id
	@NotNull
	@NotEmpty
	private Long idEncaissement;
	@NotNull
	@NotEmpty
	private String datePaiement;
	
	@NotNull
	@NotEmpty
	private Long montantPaye;
	
	@NotNull
	@NotEmpty
	private Long montantAvoir;
	
	@NotNull
	@NotEmpty
	private Long retenuSource;
	
	@NotNull
	@NotEmpty
	private Long numEmission;
	
	@NotNull
	@NotEmpty
	private String observation;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "numFacture")
	private Facture facture;
	

	public String getDatePaiement() {
		return datePaiement;
	}

	public void setDatePaiement(String datePaiement) {
		this.datePaiement = datePaiement;
	}

	public Long getMontantPaye() {
		return montantPaye;
	}

	public void setMontantPaye(Long montantPaye) {
		this.montantPaye = montantPaye;
	}

	public Long getMontantAvoir() {
		return montantAvoir;
	}

	public void setMontantAvoir(Long montantAvoir) {
		this.montantAvoir = montantAvoir;
	}

	public Long getRetenuSource() {
		return retenuSource;
	}

	public void setRetenuSource(Long retenuSource) {
		this.retenuSource = retenuSource;
	}

	public Long getNumEmission() {
		return numEmission;
	}

	public void setNumEmission(Long numEmission) {
		this.numEmission = numEmission;
	}

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

	public Long getIdEncaissement() {
		return idEncaissement;
	}

	public void setIdEncaissement(Long idEncaissement) {
		this.idEncaissement = idEncaissement;
	}

	public Facture getFacture() {
		return facture;
	}

	public void setFacture(Facture facture) {
		this.facture = facture;
	}
	
	
	

}
