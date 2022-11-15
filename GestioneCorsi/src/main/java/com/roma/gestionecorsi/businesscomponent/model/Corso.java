package com.roma.gestionecorsi.businesscomponent.model;

import java.util.Date;

public class Corso {
	private long codCorso;
	private String nomeCorso;
	private Date dataInizio;
	private Date dataFine;
	private double costo;
	private String commento;
	private String aulaCorso;
	private long codDocente;
	private int postiOccupati;
	
	public int getPostiOccupati() {
		return postiOccupati;
	}

	public void setPostiOccupati(int postiOccupati) {
		this.postiOccupati = postiOccupati;
	}

	public long getCodCorso() {
		return codCorso;
	}
	
	public void setCodCorso(long codCorso) {
		this.codCorso = codCorso;
	}
	
	public String getNomeCorso() {
		return nomeCorso;
	}
	
	public void setNomeCorso(String nomeCorso) {
		this.nomeCorso = nomeCorso;
	}
	
	public Date getDataInizio() {
		return dataInizio;
	}
	
	public void setDataInizio(Date dataInizio) {
		this.dataInizio = dataInizio;
	}
	
	public Date getDataFine() {
		return dataFine;
	}
	
	public void setDataFine(Date dataFine) {
		this.dataFine = dataFine;
	}
	
	public double getCosto() {
		return costo;
	}
	
	public void setCosto(double costo) {
		this.costo = costo;
	}

	public String getCommento() {
		return commento;
	}

	public void setCommento(String commento) {
		this.commento = commento;
	}

	public String getAulaCorso() {
		return aulaCorso;
	}

	public void setAulaCorso(String aulaCorso) {
		this.aulaCorso = aulaCorso;
	}

	public long getCodDocente() {
		return codDocente;
	}

	public void setCodDocente(long codDocente) {
		this.codDocente = codDocente;
	}

	@Override
	public String toString() {
		return "Corso [codCorso=" + codCorso + ", nomeCorso=" + nomeCorso + ", dataInizio=" + dataInizio + ", dataFine="
				+ dataFine + ", costo=" + costo + ", commento=" + commento + ", aulaCorso=" + aulaCorso
				+ ", codDocente=" + codDocente + ", postiOccupati=" + postiOccupati + "]";
	}

	
}
