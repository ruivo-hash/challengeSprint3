package br.com.fiap.dao.impl;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.dao.FuncionarioDao;
import br.com.fiap.entity.Funcionario;
import br.com.fiap.enums.Categoria;

public class FuncionarioDaoImpl extends GenericDaoImpl<Funcionario, Integer> implements FuncionarioDao{

	public FuncionarioDaoImpl(EntityManager em) {
		super(em);
	}

	@Override
	public List<Funcionario> buscarPorParteNome(String nome) {
		return em.createQuery("from Funcionario f where lower(f.nome) like lower(:n) order by f.nome", Funcionario.class).setParameter("n", "%"+nome+"%").getResultList();
	}

	@Override
	public List<Funcionario> buscarPorIntervaloTempo(Calendar dt1, Calendar dt2) {
		return em.createQuery("from Funcionario f where f.dtAdmissao between :i and :f", Funcionario.class).setParameter("i", dt1).setParameter("f", dt2).setMaxResults(50).getResultList();
	}
	
	@Override
	public List<Funcionario> buscarPorParteNomeECategoria(String nome, Categoria categoria) {
		return em.createQuery("from Funcionario f where f.nome like :n and f.categoria = :c", Funcionario.class).setParameter("n", "%"+nome+"%").setParameter("c", categoria).getResultList();
	}

	@Override
	public List<Funcionario> buscar2FuncionariosPeloHospital(String nmHospital) {
		return em.createQuery("select h.funcionarios from Hospital h where h.nome = :h", Funcionario.class).setParameter("h", nmHospital).setFirstResult(0).setMaxResults(2).getResultList();
	}

	@Override
	public long buscarQtdFuncMesmaIdade(int idade) {
		return em.createQuery("select count(f) from Funcionario f where f.idade = :i", Long.class).setParameter("i", idade).getSingleResult();
	}

}
