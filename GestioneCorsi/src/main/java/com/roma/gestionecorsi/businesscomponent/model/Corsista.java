package com.roma.gestionecorsi.businesscomponent.model;

public class Corsista {
	
	String nomeCorsista;
	String cognomeCorsista;
	long codiceCorsista;
	private boolean precedentiFormativi;
	
	public Corsista() {}

	public String getNomeCorsista() {
		return nomeCorsista;
	}

	public void setNomeCorsista(String nomeCorsista) {
		this.nomeCorsista = nomeCorsista;
	}

	public String getCognomeCorsista() {
		return cognomeCorsista;
	}

	public void setCognomeCorsista(String cognomeCorsista) {
		this.cognomeCorsista = cognomeCorsista;
	}

	public long getCodiceCorsista() {
		return codiceCorsista;
	}

	public void setCodiceCorsista(long codiceCorsista) {
		this.codiceCorsista = codiceCorsista;
	}

	public boolean isPrecedentiFormativi() {
		return precedentiFormativi;
	}

	public void setPrecedentiFormativi(boolean precedentiFormativi) {
		this.precedentiFormativi = precedentiFormativi;
	}

	@Override
	public String toString() {
		return "Corsista [nomeCorsista=" + nomeCorsista + ", cognomeCorsista=" + cognomeCorsista + ", codiceCorsista="
				+ codiceCorsista + ", precedentiFormativi=" + precedentiFormativi + "]";
	}
	
	
}
