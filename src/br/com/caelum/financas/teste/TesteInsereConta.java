package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteInsereConta {
	
	public static void main(String[] args) {
		//Calculando tempo de execucao:
		long inicio = System.currentTimeMillis();
		
		
		EntityManager manager = new JPAUtil().getEntityManager();
		
		Conta conta = new Conta();
		conta.setTitular("Carlos Franco");
		conta.setBanco("Banco Brasil");
		conta.setNumero("159357-5");
		conta.setAgencia("02589");
		
		manager.getTransaction().begin();
		manager.persist(conta);
		manager.getTransaction().commit();
		manager.close();
		
		long fim = System.currentTimeMillis();
		System.out.println("Conta Gravada com sucesso! Tempo de execucao = " + (fim-inicio) + "ms");
	}
}
