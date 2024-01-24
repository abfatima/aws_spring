package com.sip.ams.entities;

import java.time.LocalDate;

public class CompteBancaire {
	
	
	private int numCompte;
	private String proprietaire;
	private double solde;
	private LocalDate dateCreation;
	private int idBanque;
	private String telephone;
	private String email;
	
	public CompteBancaire(int numCompte, String proprietaire, double solde, LocalDate dateCreation, int idBanque,
			String telephone, String email, Double salaire) {
		super();
		this.numCompte = numCompte;
		this.proprietaire = proprietaire;
		this.solde = solde;
		this.dateCreation = dateCreation;
		this.idBanque = idBanque;
		this.telephone = telephone;
		this.email = email;
		this.salaire = salaire;
	}
	
	
	@Override
	public String toString() {
		return "CompteBancaire [numCompte=" + numCompte + ", proprietaire=" + proprietaire + ", solde=" + solde
				+ ", dateCreation=" + dateCreation + ", idBanque=" + idBanque + ", telephone=" + telephone + ", email="
				+ email + ", salaire=" + salaire + "]";
	}


	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	private Double salaire;
	
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public Double getSalaire() {
		return salaire;
	}
	public void setSalaire(Double salaire) {
		this.salaire = salaire;
	}
	public int getNumCompte() {
		return numCompte;
	}
	public void setNumCompte(int numCompte) {
		this.numCompte = numCompte;
	}
	public String getProprietaire() {
		return proprietaire;
	}
	public void setProprietaire(String proprietaire) {
		this.proprietaire = proprietaire;
	}
	public double getSolde() {
		return solde;
	}
	public void setSolde(double solde) {
		this.solde = solde;
	}
	public LocalDate getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(LocalDate dateCreation) {
		this.dateCreation = dateCreation;
	}
	public int getIdBanque() {
		return idBanque;
	}
	public void setIdBanque(int idBanque) {
		this.idBanque = idBanque;
	}
	
	
	
	

}
