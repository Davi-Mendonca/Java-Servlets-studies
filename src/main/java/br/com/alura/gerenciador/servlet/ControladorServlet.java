package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.acao.Acao;

// CONTROLADOR RESPONSAVEL POR DIRECIONAR AS REQUISIÇÕES

@WebServlet(urlPatterns = "/entrada")
public class ControladorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
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
		
		String nomeDaClasse = "br.com.alura.gerenciador.acao." + paramAcao;
		
		String nome;
		try {
			Class classe = Class.forName(nomeDaClasse);
			Acao acao = (Acao) classe.newInstance();
			nome = acao.executa(request, response);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			throw new ServletException(e);
		}
		
		String[] dispatchOrRedirect = nome.split(":");
		if (dispatchOrRedirect[0].equals("forward")) {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/" + dispatchOrRedirect[1]);
			rd.forward(request, response);
		} else {
			response.sendRedirect("entrada?acao=" + dispatchOrRedirect[1]);
		}
		
	}

}
