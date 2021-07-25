package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AutorizacaoFilter implements Filter {

	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
		
		System.out.println("AutorizacaoFilter");
	
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		
		String paramAcao = request.getParameter("acao");
		
		if(paramAcao.equals("Cadastrar")) {
			System.out.println("login: " + request.getParameter("login") + "  senha: " + request.getParameter("senha"));
		}
		
		HttpSession sessao = request.getSession();
		boolean logado = sessao.getAttribute("usuarioLogado") != null;
		boolean acaoProtegida = !(paramAcao.equals("LoginForm") || paramAcao.equals("Login") || paramAcao.equals("CadastrarUsuarioForm") || paramAcao.equals("Cadastrar"));
		
		if(acaoProtegida && !logado) {
			response.sendRedirect("entrada?acao=LoginForm");
			return;
		}
		
		chain.doFilter(request, response);
	}

}
