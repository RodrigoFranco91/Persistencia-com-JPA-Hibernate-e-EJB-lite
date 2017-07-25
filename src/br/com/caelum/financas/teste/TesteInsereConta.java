package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.caelum.financas.dao.ContaDAO;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteInsereConta {
	
	public static void main(String[] args) {
		//Calculando tempo de execucao:
		long inicio = System.currentTimeMillis();
		
		
		EntityManager manager = new JPAUtil().getEntityManager();
		ContaDAO contaDAO = new ContaDAO(manager);
		
		Conta conta = new Conta();
		conta.setTitular("Priscila Oliveira");
		conta.setBanco("Banco Santander");
		conta.setNumero("159357-5");
		conta.setAgencia("02589");
		
		manager.getTransaction().begin();
		contaDAO.adiciona(conta);
		manager.getTransaction().commit();
		manager.close();
		
		long fim = System.currentTimeMillis();
		System.out.println("Conta Gravada com sucesso! Tempo de execucao = " + (fim-inicio) + "ms.");
	}
}
