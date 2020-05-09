package com.amani.backend.entity;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Client {
	

	@Id
	@NotNull
	@NotEmpty
	private Long codeClient;
	
	@NotNull
	@NotEmpty
	private Long idDouane;
	
	@NotNull
	@NotEmpty
	private String nom;
	
	@NotNull
	@NotEmpty
	private String addresse;
	
	@NotNull
	@NotEmpty
	private String ville;
	
	@NotNull
	@NotEmpty
	private Long codePostal;
	
	@NotNull
	@NotEmpty
	private String matriculeFiscal;
	
	@NotNull
	@NotEmpty
	private Long telephone;
	
	@OneToMany(mappedBy = "client")
	private List<Compte> comptes= new LinkedList<>();
	
	@NotNull
	@NotEmpty
	private Long fax;
	
	@NotNull
	@NotEmpty
	private String email;
	
	@NotNull
	@NotEmpty
	private Boolean exonere;
	
	@OneToMany(mappedBy = "client")
	private List<Facture> factures= new LinkedList<>();
	
	
	public Long getCodeClient() {
		return codeClient;
	}
	public void setCodeClient(Long codeClient) {
		this.codeClient = codeClient;
	}
	public Long getIdDouane() {
		return idDouane;
	}
	public void setIdDouane(Long idDouane) {
		this.idDouane = idDouane;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getAddresse() {
		return addresse;
	}
	public void setAddresse(String addresse) {
		this.addresse = addresse;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public Long getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(Long codePostal) {
		this.codePostal = codePostal;
	}
	public String getMatriculeFiscal() {
		return matriculeFiscal;
	}
	public void setMatriculeFiscal(String matriculeFiscal) {
		this.matriculeFiscal = matriculeFiscal;
	}
	public Long getTelephone() {
		return telephone;
	}
	public void setTelephone(Long telephone) {
		this.telephone = telephone;
	}
	public Long getFax() {
		return fax;
	}
	public void setFax(Long fax) {
		this.fax = fax;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<Compte> getComptes() {
		return comptes;
	}
	public void setComptes(List<Compte> comptes) {
		this.comptes = comptes;
	}
	public List<Facture> getFactures() {
		return factures;
	}
	public void setFactures(List<Facture> factures) {
		this.factures = factures;
	}
	public Boolean getExonere() {
		return exonere;
	}
	public void setExonere(Boolean exonere) {
		this.exonere = exonere;
	}
	
	
	
	
	

}
