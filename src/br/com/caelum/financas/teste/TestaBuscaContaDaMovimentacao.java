package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.MovimentacaoDAO;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TestaBuscaContaDaMovimentacao {

	public static void main(String[] args) {
		EntityManager manager = new JPAUtil().getEntityManager();
		MovimentacaoDAO mdao = new MovimentacaoDAO(manager);
		
		Movimentacao movimentacao = mdao.busca(5);
		System.out.println("O titular da conta dessa movimentacao é o: " + movimentacao.getConta().getTitular());
	}
}
