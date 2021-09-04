package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.HospitalDao;
import br.com.fiap.entity.Hospital;

public class HospitalDaoImpl extends GenericDaoImpl<Hospital, Integer> implements HospitalDao{

	public HospitalDaoImpl(EntityManager em) {
		super(em);
	}

}
