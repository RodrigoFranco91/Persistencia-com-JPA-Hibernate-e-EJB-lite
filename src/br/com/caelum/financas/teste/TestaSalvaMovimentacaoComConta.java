package br.com.caelum.financas.teste;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.ContaDAO;
import br.com.caelum.financas.dao.MovimentacaoDAO;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TestaSalvaMovimentacaoComConta {
	
	public static void main(String[] args) {
		EntityManager manager = new JPAUtil().getEntityManager();
		Conta c = new Conta();
		Movimentacao m = new Movimentacao();
		MovimentacaoDAO mdao = new MovimentacaoDAO(manager);
		ContaDAO contaDAO = new ContaDAO(manager);
		
		c.setBanco("Banco EntroPay");
		c.setNumero("99999-9");
		c.setAgencia("999");
		c.setTitular("Breno Netto");
		
		m.setConta(c);
		m.setData(Calendar.getInstance());
		m.setDescricao("Conta de Jogos");
		m.setValor(new BigDecimal("250"));
		m.setTipoMovimentacao(TipoMovimentacao.SAIDA);
		
		manager.getTransaction().begin();
		contaDAO.adiciona(c); // PRIMEIRO TEMOS QUE TIRAR O OJETO CONTA DO ESTADO TRANSIENTE, POIS A CONTA AINDA NAO EXISTE!
		mdao.adiciona(m);
		manager.getTransaction().commit();
		manager.close();
		
		
	}
}
