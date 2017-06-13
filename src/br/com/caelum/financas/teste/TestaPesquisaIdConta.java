package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.ContaDAO;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TestaPesquisaIdConta {

	public static void main(String[] args) {
		EntityManager manager = new JPAUtil().getEntityManager();
		ContaDAO contaDAO = new ContaDAO(manager);
		
		Conta encontrada = contaDAO.busca(1);
		
		System.out.println("O titular da conta encontrada é: "+ encontrada.getTitular());
		
		manager.close();
	}
}
