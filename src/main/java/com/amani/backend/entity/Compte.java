package com.amani.backend.entity;


import java.util.LinkedList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Compte {
	
	public enum Profil { 
		SallePublique, Transitaire, Banque, Declarant, Transport, Partenaire, Entreprise, CabinetFormation
	}
	
	public enum ModeConnexion {
		Web_RTC, SMTP, EDI_RTC, WEB, EDI_FrameRelay,WEB_FrameRelay, EDI_X25, Autre
	}
	
	@Id
	@NotNull
	@NotEmpty
	private Long codeCompte;
	
	@Enumerated(EnumType.STRING)
	@NotNull
	private Compte.Profil profile;
	
	@Enumerated(EnumType.STRING)
	@NotNull
	private Compte.ModeConnexion modeConnexion;
	
	@NotNull
	@NotEmpty
	private String dateCreation;
	
	@NotNull
	@NotEmpty
	private boolean sallePublique;
	
	@OneToOne(mappedBy = "compte")
	private Licence licence;
	
	@OneToMany(mappedBy = "compte")
	private List<Facture> factures =new LinkedList<>();	
	
	public Licence getLicence() {
		return licence;
	}

	public void setLicence(Licence licence) {
		this.licence = licence;
	}

	@ManyToOne
	@JoinColumn(name="codeClient")
	private Client client;

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Long getCodeCompte() {
		return codeCompte;
	}

	public void setCodeCompte(Long codeCompte) {
		this.codeCompte = codeCompte;
	}

	public Compte.Profil getProfile() {
		return profile;
	}

	public void setProfile(Compte.Profil profile) {
		this.profile = profile;
	}

	public Compte.ModeConnexion getModeConnexion() {
		return modeConnexion;
	}

	public void setModeConnexion(Compte.ModeConnexion modeConnexion) {
		this.modeConnexion = modeConnexion;
	}

	public String getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(String dateCreation) {
		this.dateCreation = dateCreation;
	}

	public boolean isSallePublique() {
		return sallePublique;
	}

	public void setSallePublique(boolean sallePublique) {
		this.sallePublique = sallePublique;
	}
	
	

}
