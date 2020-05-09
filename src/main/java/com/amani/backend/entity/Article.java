package com.amani.backend.entity;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Article {
	
	@Id
	@NotNull
	@NotEmpty
	private Long codeArticle;
	
	@NotNull
	@NotEmpty
	private Long Libelle;
	
	@NotNull
	@NotEmpty
	private Long prix;
	
	@NotNull
	@NotEmpty
	private Long Taxes;
	
	@ManyToMany
	@JoinTable(
			name = "fact_art",
			joinColumns = @JoinColumn(name ="codeArticle"),
			inverseJoinColumns = @JoinColumn(name="numFacture"))
	private List<Facture> factures= new LinkedList<Facture>();
	
	@ManyToMany
	@JoinTable(
			name = "comm_art",
			joinColumns = @JoinColumn(name ="codeArticle"),
			inverseJoinColumns = @JoinColumn(name="refSAP"))
	private List<Commande> commandes= new LinkedList<Commande>();

	public Long getCodeArticle() {
		return codeArticle;
	}

	public void setCodeArticle(Long codeArticle) {
		this.codeArticle = codeArticle;
	}

	public Long getLibelle() {
		return Libelle;
	}

	public void setLibelle(Long libelle) {
		Libelle = libelle;
	}

	public Long getPrix() {
		return prix;
	}

	public void setPrix(Long prix) {
		this.prix = prix;
	}

	public Long getTaxes() {
		return Taxes;
	}

	public void setTaxes(Long taxes) {
		Taxes = taxes;
	}

	public List<Facture> getFactures() {
		return factures;
	}

	public void setFactures(List<Facture> factures) {
		this.factures = factures;
	}

	public List<Commande> getCommandes() {
		return commandes;
	}

	public void setCommandes(List<Commande> commandes) {
		this.commandes = commandes;
	}
	
	
	

}
