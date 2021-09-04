package br.com.fiap.singleton;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Classe que gerencia a �nica instancia da EntityManagerFactory
 * @author maate
 *
 */
public class EntityManagerFactorySingleton {

	// 1- atributo est�tico que armazena a �nica inst�ncia
	private static EntityManagerFactory fabrica;
	
	// 2- construtor privado -> ninguem pode instanciar
	private EntityManagerFactorySingleton() {}
	
	// 3- metodo est�tico que retorna a �nica instancia
	public static EntityManagerFactory getInstance() {
		
		//validar se existe a fabrica
		if(fabrica == null) {
			fabrica = Persistence.createEntityManagerFactory("oracle");
		}
		return fabrica;
	}
}
