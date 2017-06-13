package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.ContaDAO;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TestaRemoveConta {
	
	public static void main(String[] args) {
		EntityManager manager = new JPAUtil().getEntityManager();
		ContaDAO contaDAO = new ContaDAO(manager);
		
		manager.getTransaction().begin();
		Conta contaASerDeletada = contaDAO.busca(1);
		contaDAO.remove(contaASerDeletada);
		manager.getTransaction().commit();
		manager.close();
		
	}
}
