package br.com.alura.gerenciador.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Banco {

	private static List<Empresa> lista = new ArrayList<>();
	private static List<Usuario> listaUsuarios = new ArrayList<>();
	private static int chaveSequencial = 1;
	
	public void adiciona(Empresa empresa) {
		empresa.setId(chaveSequencial++);
		Banco.lista.add(empresa);
	}
	
	public void removeEmpresa(int id) {
		
		Iterator<Empresa> it = lista.iterator();
		while (it.hasNext()) {
			Empresa empresa = it.next();
			
			if (empresa.getId() == id) {
				it.remove();
			}			
		}
	}
	
	public void cadastrarUsuario(String login, String senha) {
		listaUsuarios.add(new Usuario(login, senha));
	}
	
	public Usuario buscarUsuario(String login) {
		Iterator<Usuario> listaUsr = listaUsuarios.iterator();
		while(listaUsr.hasNext()) {
			Usuario usr = listaUsr.next();
			
			if(usr.getLogin().equals(login)) {
				return usr;
			}
		}
		
		return null;
	}
	
	public Empresa buscaEmpresaPorId(int id) {
		for (Empresa empresa: lista) {
			if(empresa.getId() == id) {
				return empresa;
			}
		}
		return null;
	}
	
	public List<Empresa> getEmpresas(){
		return Banco.lista;
	}

	public static List<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}
	
}
