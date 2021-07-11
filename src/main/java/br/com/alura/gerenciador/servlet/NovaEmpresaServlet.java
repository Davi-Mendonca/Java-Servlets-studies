package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NovaEmpresaServlet
 */
@WebServlet("/novaEmpresa")
public class NovaEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Cadastrando nova empresa...");
		
		Empresa empresa = new Empresa();
		empresa.setName(request.getParameter("name"));
				
		String stringDataAbertura = request.getParameter("data");
		
		Date dataAbertura = null;
		
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			dataAbertura = sdf.parse(stringDataAbertura);
			
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		
		empresa.setDataAbertura(dataAbertura);
		
		Banco banco = new Banco();
		banco.adiciona(empresa);
		
		// CHAMANDO JSP.
		RequestDispatcher rd = request.getRequestDispatcher("/novaEmpresaCriada.jsp");
		
		// Encapsulando atributo dentro da requisição para que possa ser utilizado no arquivo JSP.
		request.setAttribute("empresa", empresa.getName());
		
		// Despachando request e response.
		rd.forward(request, response);
	}


}
