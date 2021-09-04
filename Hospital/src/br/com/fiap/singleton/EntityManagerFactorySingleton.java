package br.com.fiap.singleton;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Classe que gerencia a única instancia da EntityManagerFactory
 * @author maate
 *
 */
public class EntityManagerFactorySingleton {

	// 1- atributo estático que armazena a única instância
	private static EntityManagerFactory fabrica;
	
	// 2- construtor privado -> ninguem pode instanciar
	private EntityManagerFactorySingleton() {}
	
	// 3- metodo estático que retorna a única instancia
	public static EntityManagerFactory getInstance() {
		
		//validar se existe a fabrica
		if(fabrica == null) {
			fabrica = Persistence.createEntityManagerFactory("oracle");
		}
		return fabrica;
	}
}
