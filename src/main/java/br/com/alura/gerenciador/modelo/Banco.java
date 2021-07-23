package br.com.alura.gerenciador.modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class Banco {

	private static List<Empresa> lista = new ArrayList<>();
	private static List<Usuario> listaUsuarios = new ArrayList<>();
	private static int chaveSequencial = 1;
	
	static {
		Empresa empresa1 = new Empresa();
		empresa1.setName("Alura");
		empresa1.setDataAbertura(new Date());
		empresa1.setId(1);
		Empresa empresa2 = new Empresa();
		empresa2.setName("Caelum");
		empresa2.setDataAbertura(new Date());
		empresa2.setId(2);
		
		lista.add(empresa1);
		lista.add(empresa2);
		
		Usuario usr1 = new Usuario("Davi", "12345");
		Usuario usr2 = new Usuario("Ariel", "12345");
		
		listaUsuarios.add(usr1);
		listaUsuarios.add(usr2);
	}
	
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
	
	public void cadastrarUsuario(Usuario usuario) {
		listaUsuarios.add(usuario);
	}
	
	public Usuario buscarUsuario(String login) {
		for(Usuario usuario : listaUsuarios) {			
			if(usuario.getLogin().equals(login)) {
				return usuario;
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
