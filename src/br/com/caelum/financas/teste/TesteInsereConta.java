package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.caelum.financas.modelo.Conta;

public class TesteInsereConta {
	
	public static void main(String[] args) {
		//Calculando tempo de execucao:
		long inicio = System.currentTimeMillis();
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("controlefinancas");
		EntityManager manager = factory.createEntityManager();
		
		Conta conta = new Conta();
		conta.setTitular("Rodrigo Franco");
		conta.setBanco("Banco Itau");
		conta.setNumero("147852-2");
		conta.setAgencia("05656");
		
		manager.getTransaction().begin();
		manager.persist(conta);
		manager.getTransaction().commit();
		manager.close();
		
		long fim = System.currentTimeMillis();
		System.out.println("Conta Gravada com sucesso! Tempo de execucao = " + (fim-inicio) + "ms");
	}
}
