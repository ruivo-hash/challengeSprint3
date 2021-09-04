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
import br.com.fiap.entity.Convenio;
import br.com.fiap.entity.Fornecedor;
import br.com.fiap.entity.Funcionario;
import br.com.fiap.entity.Hospital;
import br.com.fiap.entity.Paciente;
import br.com.fiap.entity.Pagamento;
import br.com.fiap.enums.Categoria;
import br.com.fiap.enums.FormaPagamento;
import br.com.fiap.enums.ProdutoFornecido;
import br.com.fiap.enums.TipoConvenio;
import br.com.fiap.exception.CommitException;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

public class UpdateTest {

	public static void main(String[] args) {

		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		ConvenioDao conDao = new ConvenioDaoImpl(em);
		Convenio con = new Convenio(1, TipoConvenio.ALLIANZ_SAUDE);
		try {
			conDao.update(con);
			conDao.commit();
			System.out.println("Convênio atualizado");
		} catch (CommitException e) {
			System.out.println(e.getMessage());
		}
		
		FornecedorDao forDao = new FornecedorDaoImpl(em);
		Fornecedor forn = new Fornecedor(1, "Distribuidora food SA", "24.143.123/0002-01", ProdutoFornecido.COMIDA, "(11) 98765-4321");
		try {
			forDao.update(forn);
			forDao.commit();
			System.out.println("Fornecedor atualizado");
		} catch (CommitException e) {
			System.out.println(e.getMessage());
		}
		
		FuncionarioDao funDao = new FuncionarioDaoImpl(em);
		Funcionario fun = new Funcionario(1, "Lilian", Categoria.MEDICO, "9876543", 30, true);
		try {
			funDao.update(fun);
			funDao.commit();
			System.out.println("Funcionário atualizado");
		} catch (CommitException e) {
			System.out.println(e.getMessage());
		}
		
		HospitalDao hosDao = new HospitalDaoImpl(em);
		Hospital hos = new Hospital(1, "Hopital das Curas", "98.765.432/0002-09");
		try {
			hosDao.update(hos);
			hosDao.commit();
			System.out.println("Hospital atualizado");
		} catch (CommitException e) {
			System.out.println(e.getMessage());
		}
		
		PacienteDao pacDao = new PacienteDaoImpl(em);
		Paciente pac = new Paciente(1, "Fernanda", 25, "465.456.456/03");
		try {
			pacDao.update(pac);
			pacDao.commit();
			System.out.println("Paciente atualizado");
		} catch (CommitException e) {
			System.out.println(e.getMessage());
		}
		
		PagamentoDao pagDao = new PagamentoDaoImpl(em);
		Pagamento pag = new Pagamento(1, FormaPagamento.DINHEIRO, 250.00, pac);
		try {
			pagDao.update(pag);
			pagDao.commit();
			System.out.println("Pagamento atualizado");
		} catch (CommitException e) {
			System.out.println(e.getMessage());
		}
	}
}
