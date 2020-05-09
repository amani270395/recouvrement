package com.amani.backend.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Licence {
	
	@Id
	@NotNull
	@NotEmpty
	private Long refRecouvrement;
	
	@NotNull
	@NotEmpty
	private Long codeArticle;
	
	
	
	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	@NotNull
	@NotEmpty
	private String dateAcquis;
	
	@NotNull
	@NotEmpty
	private String dateInstall;
	
	@NotNull
	@NotEmpty
	private String agent;
	
	@NotNull
	@NotEmpty
	private String profile;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="codeCompte")
	private Compte compte;
	
	@OneToOne(mappedBy = "licence")
	private Commande commande;

	public Long getRefRecouvrement() {
		return refRecouvrement;
	}

	public void setRefRecouvrement(Long refRecouvrement) {
		this.refRecouvrement = refRecouvrement;
	}

	public Long getCodeArticle() {
		return codeArticle;
	}

	public void setCodeArticle(Long codeArticle) {
		this.codeArticle = codeArticle;
	}

	public String getDateAcquis() {
		return dateAcquis;
	}

	public void setDateAcquis(String dateAcquis) {
		this.dateAcquis = dateAcquis;
	}

	public String getDateInstall() {
		return dateInstall;
	}

	public void setDateInstall(String dateInstall) {
		this.dateInstall = dateInstall;
	}

	public String getAgent() {
		return agent;
	}

	public void setAgent(String agent) {
		this.agent = agent;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}
	
	

}
