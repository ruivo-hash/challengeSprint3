package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.ConvenioDao;
import br.com.fiap.entity.Convenio;

public class ConvenioDaoImpl extends GenericDaoImpl<Convenio, Integer> implements ConvenioDao{

	public ConvenioDaoImpl(EntityManager em) {
		super(em);
	}

}
