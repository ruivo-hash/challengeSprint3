package br.com.fiap.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.dao.PagamentoDao;
import br.com.fiap.entity.Pagamento;

public class PagamentoDaoImpl extends GenericDaoImpl<Pagamento, Integer> implements PagamentoDao{

	public PagamentoDaoImpl(EntityManager em) {
		super(em);
	}

	@Override
	public List<Pagamento> buscar2Pagamentos(String nome) {
		return em.createQuery("from Pagamento p where p.paciente.nome = :n", Pagamento.class).setParameter("n", nome).setFirstResult(0).setMaxResults(2).getResultList();
	}

}
