package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.FornecedorDao;
import br.com.fiap.entity.Fornecedor;

public class FornecedorDaoImpl extends GenericDaoImpl<Fornecedor, Integer> implements FornecedorDao{

	public FornecedorDaoImpl(EntityManager em) {
		super(em);
	}

}
