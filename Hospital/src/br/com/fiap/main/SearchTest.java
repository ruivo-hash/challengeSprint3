package br.com.fiap.main;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.dao.FuncionarioDao;
import br.com.fiap.dao.PagamentoDao;
import br.com.fiap.dao.impl.FuncionarioDaoImpl;
import br.com.fiap.dao.impl.PagamentoDaoImpl;
import br.com.fiap.entity.Funcionario;
import br.com.fiap.entity.Pagamento;
import br.com.fiap.enums.Categoria;
import br.com.fiap.singleton.EntityManagerFactorySingleton;
import br.com.fiap.util.DataUtil;

public class SearchTest {

	public static void main(String[] args) {
		
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
				
		//a pesquisar por parte de uma string, sem considerar maiuscula e minuscula
		// retornando uma lista ordenada(order by)
		// pesquisar funcionario por parte do nome sem case sensitive retornando os nomes em ordem crescente
		FuncionarioDao funDao = new FuncionarioDaoImpl(em);
		List<Funcionario> funcionarios = funDao.buscarPorParteNome("a");
		System.out.println("Busca por parte do nome");
		funcionarios.forEach(f -> System.out.println(f.getNome()));
		
		
		//b pesquisar por intervalo de datas
		//  retornar lista com no max 50 parametros
		// buscar funcionarios admitidos entre duas datas
		Calendar dt1 = new GregorianCalendar(2021, Calendar.JANUARY, 1);
		Calendar dt2 = new GregorianCalendar(2021, Calendar.DECEMBER, 31);
		funcionarios = funDao.buscarPorIntervaloTempo(dt1, dt2);
		System.out.println("buscar funcionarios admitidos entre duas datas");
		funcionarios.forEach(f -> System.out.println(f.getNome()+" "+DataUtil.formatar(f.getDtAdmissao())));
		
		
		//c pesquisar utilizando dois parametros
		//  retornar uma lista
		// buscar por parte do nome e categoria
		funcionarios = funDao.buscarPorParteNomeECategoria("a", Categoria.MEDICO);
		System.out.println("buscar por parte do nome e categoria");
		funcionarios.forEach(f -> System.out.println(f.getNome()+" "+f.getCategoria()));
		
		//d pesquisar navegando entre os atributos de relacionamento
		//  lista com no max 2 atributos preenchidos
		// buscar os 2 primeiros pagamentos de um paciente, pelo nome do paciente
		PagamentoDao pagDao = new PagamentoDaoImpl(em);
		List<Pagamento> pagamentos = pagDao.buscar2Pagamentos("Ana");
		System.out.println("buscar os 2 primeiros pagamentos de um paciente");
		pagamentos.forEach(p -> System.out.println(p.getValor()+" "+DataUtil.formatar(p.getDtPagamento())));
		
		
		//e pesquisar por qualquer parâmentro
		//  retornar um numero que pode ser a soma, max, min. quantidade ou média
		// buscar quantidade de funcionarios com a mesma idade
		long qntd = funDao.buscarQtdFuncMesmaIdade(24);
		System.out.println("quantidade de funcionarios com essa idade: "+ qntd);
		
	}
}
