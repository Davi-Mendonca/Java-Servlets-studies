package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.acao.AlteraEmpresa;
import br.com.alura.gerenciador.acao.ListaEmpresas;
import br.com.alura.gerenciador.acao.MostraEmpresa;
import br.com.alura.gerenciador.acao.NovaEmpresa;
import br.com.alura.gerenciador.acao.NovaEmpresaForm;
import br.com.alura.gerenciador.acao.RemoveEmpresa;

// CONTROLADOR RESPONSAVEL POR DIRECIONAR AS REQUISIÇÕES

@WebServlet("/entrada")
public class UnicaEntradaServltet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String paramAcao = request.getParameter("acao");
		
		String acao = null;
		if(paramAcao.equals("listaEmpresas")) {			
			ListaEmpresas listaEmpresas = new ListaEmpresas();
			acao = listaEmpresas.listar(request, response);
						
		}else if(paramAcao.equals("removeEmpresa")) {
			RemoveEmpresa removeEmpresa = new RemoveEmpresa();
			acao = removeEmpresa.remover(request, response);
			
		}else if(paramAcao.equals("mostraEmpresa")) {
			MostraEmpresa mostraEmpresa = new MostraEmpresa();
			acao = mostraEmpresa.mostrar(request, response);
			
		}else if(paramAcao.equals("novaEmpresa")) {
			NovaEmpresa novaEmpresa = new NovaEmpresa();
			acao = novaEmpresa.cadastrar(request, response);
			
		}else if (paramAcao.equals("alteraEmpresa")) {
			AlteraEmpresa alteraEmpresa = new AlteraEmpresa();
			acao = alteraEmpresa.alterar(request, response);
		}else if (paramAcao.equals("novaEmpresaForm")) {
			NovaEmpresaForm novaEmpresaForm = new NovaEmpresaForm();
			acao = novaEmpresaForm.chamaFormulario(request, response);
		}
		
		
		
		String[] dispatchOrRedirect = acao.split(":");
		if (dispatchOrRedirect[0].equals("forward")) {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/" + dispatchOrRedirect[1]);
			rd.forward(request, response);
		} else {
			response.sendRedirect(dispatchOrRedirect[1]);
		}
		
	}

}
