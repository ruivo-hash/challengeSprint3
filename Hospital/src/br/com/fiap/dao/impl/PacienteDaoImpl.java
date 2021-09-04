package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.PacienteDao;
import br.com.fiap.entity.Paciente;

public class PacienteDaoImpl extends GenericDaoImpl<Paciente, Integer> implements PacienteDao{

	public PacienteDaoImpl(EntityManager em) {
		super(em);
	}
}
