package br.com.fiap.main;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.dao.FornecedorDao;
import br.com.fiap.dao.FuncionarioDao;
import br.com.fiap.dao.HospitalDao;
import br.com.fiap.dao.PacienteDao;
import br.com.fiap.dao.PagamentoDao;
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

public class CreateTest {

	public static void main(String[] args) {
		
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		Convenio convenio = new Convenio(TipoConvenio.BRADESCO_SAUDE);
		Convenio convenio1 = new Convenio(TipoConvenio.ALLIANZ_SAUDE);
		Convenio convenio2 = new Convenio(TipoConvenio.PORTO_SEGURO);
		
		PacienteDao pacDao = new PacienteDaoImpl(em);
		Paciente paciente = new Paciente("Fernanda", 19, "123.123.123/01", convenio);
		Paciente paciente1 = new Paciente("Mateus", 20, "123.123.123/01", convenio1);
		Paciente paciente2 = new Paciente("Felipe", 21, "123.123.123/01", convenio2);
		Paciente paciente3 = new Paciente("Ana", 19, "453.357.246/01", convenio);
		Paciente paciente4 = new Paciente("Pedro", 20, "453.357.246/01", convenio);
		try {
			pacDao.create(paciente);
			pacDao.commit();
			System.out.println("Pacientes cadastrado");
		} catch (CommitException e) {
			System.out.println(e.getMessage());
		}
		
		PagamentoDao pagDao = new PagamentoDaoImpl(em);
		Pagamento pagamento = new Pagamento(FormaPagamento.CARTAO_CREDITO, 115.00, paciente3);
		Pagamento pagamento1 = new Pagamento(FormaPagamento.BOLETO, 250.00, paciente3);
		Pagamento pagamento2 = new Pagamento(FormaPagamento.CARTAO_DEBITO, 105.00, paciente3);
		try {
			pagDao.create(pagamento);
			pagDao.create(pagamento1);
			pagDao.create(pagamento2);
			pagDao.commit();
			System.out.println("Pagamento cadastrado");
		} catch (CommitException e) {
			System.out.println(e.getMessage());
		}
		
		
		FornecedorDao forDao = new FornecedorDaoImpl(em);
		Fornecedor fornecedor = new Fornecedor("Limpeza LTDA", "65.986.652/0001-01", ProdutoFornecido.PRODUTOS_LIMPEZA, "limpezaltda@email.com.br");
		Fornecedor fornecedor1 = new Fornecedor("Restaurante", "25.855.855/0001-01", ProdutoFornecido.COMIDA, "restaurante@email.com.br");
		Fornecedor fornecedor2 = new Fornecedor("Farmacia", "12.123.123/0001-01", ProdutoFornecido.REMEDIOS, "farmacia@email.com.br");
		try {
			forDao.create(fornecedor);
			forDao.commit();
			System.out.println("Fornecedores cadastrado");
		} catch (CommitException e) {
			System.out.println(e.getMessage());
		}
		
		FuncionarioDao funDao = new FuncionarioDaoImpl(em);
		Funcionario funcionario = new Funcionario("Guto", Categoria.FISIOTERAPEUTA, "1234567", 22, true);
		Funcionario funcionario1 = new Funcionario("Jessica", Categoria.ENFERMEIRO, "7654321", 23, true);
		Funcionario funcionario2 = new Funcionario("Lilian", Categoria.MEDICO, "1649735", 24, true);
		Funcionario funcionario3 = new Funcionario("Amanda", Categoria.MEDICO, "1649735", 24, true);
		Funcionario funcionario4 = new Funcionario("Zélia", Categoria.MEDICO, "1649735", 24, true);
		try {
			funDao.create(funcionario);
			funDao.commit();
			System.out.println("Funcionários cadastrado");
		} catch (CommitException e) {
			System.out.println(e.getMessage());
		}
		
		List<Paciente> pacientes = new ArrayList<>();
		pacientes.add(paciente1);
		pacientes.add(paciente2);
		pacientes.add(paciente4);
		
		List<Fornecedor> fornecedores = new ArrayList<>();
		fornecedores.add(fornecedor1);
		fornecedores.add(fornecedor2);
		
		List<Funcionario> funcionarios = new ArrayList<>();
		funcionarios.add(funcionario1);
		funcionarios.add(funcionario2);
		funcionarios.add(funcionario3);
		funcionarios.add(funcionario4);
		
		Hospital hos = new Hospital("Hopital da Dores", "12.345.678/0001-90", pacientes, fornecedores, funcionarios);
//		Hospital hos1 = new Hospital("Hopital Vasconcelos", "65.526.158/0001-90");
//		Hospital hos2 = new Hospital("Hopital São Luiz", "45.685.953/0001-90");
		
		HospitalDao hosDao = new HospitalDaoImpl(em);
		try {
			hosDao.create(hos);
			hosDao.commit();
			System.out.println("Hospital cadastrado");
		} catch (CommitException e) {
			System.out.println(e.getMessage());
		}
	}
}