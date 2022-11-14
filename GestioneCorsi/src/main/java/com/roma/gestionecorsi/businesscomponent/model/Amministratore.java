package com.roma.gestionecorsi.businesscomponent.model;

public class Amministratore {
	private long codAdmin;
	private String nomeAdmin;
	private String cognomeAdmin;
	
	public long getCodAdmin() {
		return codAdmin;
	}
	public void setCodAdmin(long codAdmin) {
		this.codAdmin = codAdmin;
	}
	public String getNomeAdmin() {
		return nomeAdmin;
	}
	public void setNomeAdmin(String nomeAdmin) {
		this.nomeAdmin = nomeAdmin;
	}
	public String getCognomeAdmin() {
		return cognomeAdmin;
	}
	public void setCognomeAdmin(String cognomeAdmin) {
		this.cognomeAdmin = cognomeAdmin;
	}
	@Override
	public String toString() {
		return "Amministratore [codAdmin=" + codAdmin + ", nomeAdmin=" + nomeAdmin + ", cognomeAdmin=" + cognomeAdmin
				+ "]";
	}
}