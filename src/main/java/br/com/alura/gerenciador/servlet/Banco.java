package br.com.alura.gerenciador.servlet;

import java.util.ArrayList;
import java.util.List;

public class Banco {

	private static List<Empresa> lista = new ArrayList<>();
	private static int chaveSequencial = 1;
	
	public void adiciona(Empresa empresa) {
		empresa.setId(chaveSequencial++);
		Banco.lista.add(empresa);
	}
	
	public void remove(int id) {
		for (Empresa empresa: lista) {
			if (empresa.getId() == id) {
				lista.remove(empresa);
			}
		}
	}
	
	public List<Empresa> getEmpresas(){
		return Banco.lista;
	}
	
}
