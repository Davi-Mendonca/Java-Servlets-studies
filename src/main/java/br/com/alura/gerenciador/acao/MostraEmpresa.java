package br.com.alura.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;

public class MostraEmpresa implements Acao {

	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("mostrando empresas...");
		
		String paramId = request.getParameter("id");
		int empresaId = Integer.parseInt(paramId);
		
		Banco banco = new Banco();
		
		Empresa empresa = banco.buscaEmpresaPorId(empresaId);
		
		request.setAttribute("empresa", empresa);
//		RequestDispatcher rd = request.getRequestDispatcher("/formAlteraEmpresa.jsp");
//		rd.forward(request, response);

		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		return "forward:formAlteraEmpresa.jsp";
	}

}
