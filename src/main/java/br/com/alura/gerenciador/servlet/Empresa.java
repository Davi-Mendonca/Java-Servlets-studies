package br.com.alura.gerenciador.servlet;

import java.util.Date;

public class Empresa {

	private int id;
	private String name;
	private Date dataAbertura;
	
	Empresa(){
		// Definindo uma data apenas para testes
		this.setDataAbertura(new Date());
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public void setDataAbertura(Date localDate) {
		this.dataAbertura = localDate;
	}
	
	public Date getDataAbertura() {
		return dataAbertura;
	}
	
}
