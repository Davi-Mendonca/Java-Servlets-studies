package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AlteraEmpresaServlet
 */
@WebServlet("/alteraEmpresa")
public class AlteraEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Empresa empresa = new Empresa();
		
		int paramId = Integer.parseInt(request.getParameter("id"));
		
		Banco banco = new Banco();
		
		empresa = banco.buscaEmpresaPorId(paramId);
		empresa.setId(request.getParameter("id"));
		empresa.setName(request.getParameter("name"));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
//		String stringDataAbertura = request.getParameter("data");
//		int paramId = Integer.parseInt(request.getParameter("id"));
//		empresa.setName(request.getParameter("name"));
//		empresa.setId(paramId);
//		
//		Date dataAbertura = null;
//		
//		try {
//			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//			dataAbertura = sdf.parse(stringDataAbertura);
//			
//		} catch (ParseException e) {
//			throw new ServletException(e);
//		}
		
		
		
		
	}

}
