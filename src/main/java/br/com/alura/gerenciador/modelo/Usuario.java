package br.com.alura.gerenciador.modelo;

public class Usuario {

	private String login;
	private String Senha;
	
	public Usuario() {
		
	}
	
	public Usuario(String login, String senha) {
		this.login = login;
		this.Senha = senha;
	}
	
	public boolean autenticar(String login, String senha) {
		Banco banco = new Banco();
		
		Usuario usuario = banco.buscarUsuario(login);
		
		if(usuario.getLogin().equals(login) && usuario.getSenha().equals(senha)) {
			return true;
		}
		
		return false;
	}
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return Senha;
	}
	public void setSenha(String senha) {
		Senha = senha;
	}
	
}
