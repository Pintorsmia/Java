package amazon.java;

import java.io.Serializable;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Colis implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue
	private long numero;
	private float poids, valeur;
	private String origine, destination;
	/*
	public Colis(float poids, float valeur, String origine, String destination) {
		this.poids = poids;
		this.valeur = valeur;
		this.origine = origine;
		this.destination = destination;
	}*/
	public Colis() {}
	
	public void setColis(float poids, float valeur, String origine, String destination) {
		this.poids = poids;
		this.valeur = valeur;
		this.origine = origine;
		this.destination = destination;
		
	}
	
	public float getPoids() {
		return poids;
	}
	public void setPoids(float poids) {
		this.poids = poids;
	}
	public float getValeur() {
		return valeur;
	}
	public void setValeur(float valeur) {
		this.valeur = valeur;
	}
	public String getOrigine() {
		return origine;
	}
	public void setOrigine(String origine) {
		this.origine = origine;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}

	public long getNumero() {
		return numero;
	}

	public void setNumero(long numero) {
		this.numero = numero;
	}
}
