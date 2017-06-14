package br.com.caelum.financas.teste;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TesteInsereMovimentacao {
	
	public static void main(String[] args) {
		
		Movimentacao m = new Movimentacao();
		EntityManager manager = new JPAUtil().getEntityManager();
		
		m.setDescricao("Conta de PSN");
		m.setValor(new BigDecimal("100"));
		m.setTipoMovimentacao(TipoMovimentacao.SAIDA);
		
		manager.getTransaction().begin();
		manager.persist(m);
		manager.getTransaction().commit();
		manager.close();
	}
}
