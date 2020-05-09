package com.amani.backend.entity;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Commande {
	@Id
	@NotNull
	@NotEmpty
	private Long refSAP;
	
	
	@NotNull
	@NotEmpty
	private Long codeClient;
	
	@NotNull
	@NotEmpty
	private String date;
	
	@NotNull
	@NotEmpty
	private String observation;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "refRecouvrement")
	private Licence licence;
	
	@ManyToMany(mappedBy = "commandes")
	private List<Article> articles=new LinkedList<Article>();
	
	public Long getRefSAP() {
		return refSAP;
	}

	public void setRefSAP(Long refSAP) {
		this.refSAP = refSAP;
	}

	public Long getCodeClient() {
		return codeClient;
	}

	public void setCodeClient(Long codeClient) {
		this.codeClient = codeClient;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

	public Licence getLicence() {
		return licence;
	}

	public void setLicence(Licence licence) {
		this.licence = licence;
	}

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}
	
	
	

}
