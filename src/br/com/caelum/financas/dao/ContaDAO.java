package br.com.caelum.financas.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class ContaDAO {

	private EntityManager manager;

	public ContaDAO(EntityManager manager) {
		this.manager = manager;
	}
	
	public Conta busca(Integer id){
		return this.manager.find(Conta.class, id);
	}
	
	public List<Conta> lista(){
		return this.manager.createQuery("SELECT C FROM Conta C", Conta.class).getResultList();
	}
	
	public void remove(Conta c){
		this.manager.remove(c);
	}
	
	public void adiciona(Conta c){
		this.manager.persist(c);
	}

}
