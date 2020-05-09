package com.amani.backend.entity;


import java.util.LinkedList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Facture {
	
	@Id
	@NotNull
	@NotEmpty
	private Long numFacture;
	
	@NotNull
	@NotEmpty
	private Long annee;
	
	@NotNull
	@NotEmpty
	private String dateFacture;
	
	@NotNull
	@NotEmpty
	private String periodeDeb;
	
	@NotNull
	@NotEmpty
	private String periodeFin;
	
	@NotNull
	@NotEmpty
	private String dateLimitePay;
	
	@NotNull
	@NotEmpty
	private Long montantHorsTaxe;
	
	@NotNull
	@NotEmpty
	private Long montantAvecTaxe;
	
	@NotNull
	@NotEmpty
	private Long montantTTC;
	
	@ManyToOne
	@JoinColumn(name="codeClient")
	private Client client;
	
	@ManyToOne
	@JoinColumn(name="codeCompte")
	private Compte compte;
	
	@OneToMany(mappedBy = "facture",fetch = FetchType.EAGER)
	private List<FactureAvoir> factures=new LinkedList<>();
	
	@OneToOne(mappedBy = "facture")
	private Encaissement encaissement;
	
	@OneToOne(mappedBy = "facture")
	private Paiement paiement;
	
	@ManyToMany(mappedBy = "factures")
	private List<Article> articles=new LinkedList<Article>();

	public Long getNumFacture() {
		return numFacture;
	}

	public void setNumFacture(Long numFacture) {
		this.numFacture = numFacture;
	}

	public Long getAnnee() {
		return annee;
	}

	public void setAnnee(Long annee) {
		this.annee = annee;
	}

	public String getDateFacture() {
		return dateFacture;
	}

	public void setDateFacture(String dateFacture) {
		this.dateFacture = dateFacture;
	}

	public String getPeriodeDeb() {
		return periodeDeb;
	}

	public void setPeriodeDeb(String periodeDeb) {
		this.periodeDeb = periodeDeb;
	}

	public String getPeriodeFin() {
		return periodeFin;
	}

	public void setPeriodeFin(String periodeFin) {
		this.periodeFin = periodeFin;
	}

	public String getDateLimitePay() {
		return dateLimitePay;
	}

	public void setDateLimitePay(String dateLimitePay) {
		this.dateLimitePay = dateLimitePay;
	}

	public Long getMontantHorsTaxe() {
		return montantHorsTaxe;
	}

	public void setMontantHorsTaxe(Long montantHorsTaxe) {
		this.montantHorsTaxe = montantHorsTaxe;
	}

	public Long getMontantAvecTaxe() {
		return montantAvecTaxe;
	}

	public void setMontantAvecTaxe(Long montantAvecTaxe) {
		this.montantAvecTaxe = montantAvecTaxe;
	}

	public Long getMontantTTC() {
		return montantTTC;
	}

	public void setMontantTTC(Long montantTTC) {
		this.montantTTC = montantTTC;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	public List<FactureAvoir> getFactures() {
		return factures;
	}

	public void setFactures(List<FactureAvoir> factures) {
		this.factures = factures;
	}

	public Encaissement getEncaissement() {
		return encaissement;
	}

	public void setEncaissement(Encaissement encaissement) {
		this.encaissement = encaissement;
	}

	public Paiement getPaiement() {
		return paiement;
	}

	public void setPaiement(Paiement paiement) {
		this.paiement = paiement;
	}

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}
	
	
	

}
