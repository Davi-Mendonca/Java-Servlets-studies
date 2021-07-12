package br.com.alura.gerenciador.acao;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.Banco;

public class RemoveEmpresa {

	public void remover(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("removendo empresa...");
		
		String paramId = request.getParameter("id");
		int empresaId = Integer.parseInt(paramId);
		
		Banco banco = new Banco();
		banco.remove(empresaId);
		
		response.sendRedirect("entrada?acao=listaEmpresas");
	}
}
