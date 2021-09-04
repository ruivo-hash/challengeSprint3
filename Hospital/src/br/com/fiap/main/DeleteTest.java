package br.com.fiap.main;

import javax.persistence.EntityManager;

import br.com.fiap.dao.ConvenioDao;
import br.com.fiap.dao.FornecedorDao;
import br.com.fiap.dao.FuncionarioDao;
import br.com.fiap.dao.HospitalDao;
import br.com.fiap.dao.PacienteDao;
import br.com.fiap.dao.PagamentoDao;
import br.com.fiap.dao.impl.ConvenioDaoImpl;
import br.com.fiap.dao.impl.FornecedorDaoImpl;
import br.com.fiap.dao.impl.FuncionarioDaoImpl;
import br.com.fiap.dao.impl.HospitalDaoImpl;
import br.com.fiap.dao.impl.PacienteDaoImpl;
import br.com.fiap.dao.impl.PagamentoDaoImpl;
import br.com.fiap.exception.CommitException;
import br.com.fiap.exception.EntityNotFoundException;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

public class DeleteTest {

	public static void main(String[] args) {

		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();

		ConvenioDao conDao = new ConvenioDaoImpl(em);
		try {
			conDao.delete(1);
			conDao.commit();
			System.out.println("Convênio removido");
		} catch (CommitException | EntityNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		FornecedorDao forDao = new FornecedorDaoImpl(em);
		try {
			forDao.delete(1);
			forDao.commit();
			System.out.println("Fornecedor removido");
		} catch (CommitException | EntityNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		FuncionarioDao funDao = new FuncionarioDaoImpl(em);
		try {
			funDao.delete(1);
			funDao.commit();
			System.out.println("Funcionário removido");
		} catch (CommitException | EntityNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		HospitalDao hosDao = new HospitalDaoImpl(em);
		try {
			hosDao.delete(1);
			hosDao.commit();
			System.out.println("Hospital removido");
		} catch (CommitException | EntityNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		PacienteDao pacDao = new PacienteDaoImpl(em);
		try {
			pacDao.delete(1);
			pacDao.commit();
			System.out.println("Paciente removido");
		} catch (CommitException | EntityNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		PagamentoDao pagDao = new PagamentoDaoImpl(em);
		try {
			pagDao.delete(1);
			pagDao.commit();
			System.out.println("Pagamento removido");
		} catch (CommitException | EntityNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
}
