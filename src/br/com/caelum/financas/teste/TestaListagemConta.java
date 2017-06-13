package br.com.caelum.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.ContaDAO;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TestaListagemConta {
	
	public static void main(String[] args) {
		EntityManager manager = new JPAUtil().getEntityManager();
		ContaDAO contaDAO = new ContaDAO(manager);
		
		List<Conta> contaList = contaDAO.lista();
		
		for(Conta aux : contaList){
			System.out.println("Titular da conta: " + aux.getTitular());
		}
	}
}
