package br.com.caelum.financas.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	private static EntityManagerFactory facotry = Persistence.createEntityManagerFactory("controlefinancas");

	public EntityManager getEntityManager() {
		return facotry.createEntityManager();
	}

}
