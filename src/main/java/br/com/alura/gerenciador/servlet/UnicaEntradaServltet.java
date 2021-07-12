package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.acao.AlteraEmpresa;
import br.com.alura.gerenciador.acao.ListaEmpresas;
import br.com.alura.gerenciador.acao.MostraEmpresa;
import br.com.alura.gerenciador.acao.NovaEmpresa;
import br.com.alura.gerenciador.acao.RemoveEmpresa;

/**
 * Servlet implementation class UnicaEntradaServltet
 */
@WebServlet("/entrada")
public class UnicaEntradaServltet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String paramAcao = request.getParameter("acao");
		
		if(paramAcao.equals("listaEmpresas")) {			
			ListaEmpresas listaEmpresas = new ListaEmpresas();
			listaEmpresas.listar(request, response);
			
		}else if(paramAcao.equals("removeEmpresa")) {
			RemoveEmpresa removeEmpresa = new RemoveEmpresa();
			removeEmpresa.remover(request, response);
			
		}else if(paramAcao.equals("mostraEmpresa")) {
			MostraEmpresa mostraEmpresa = new MostraEmpresa();
			mostraEmpresa.mostrar(request, response);
			
		}else if(paramAcao.equals("novaEmpresa")) {
			NovaEmpresa novaEmpresa = new NovaEmpresa();
			novaEmpresa.cadastrar(request, response);
		}else if (paramAcao.equals("alteraEmpresa")) {
			AlteraEmpresa alteraEmpresa = new AlteraEmpresa();
			alteraEmpresa.alterar(request, response);
		}
	}

}
