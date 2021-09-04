package br.com.fiap.dao;

import java.util.Calendar;
import java.util.List;

import br.com.fiap.entity.Funcionario;
import br.com.fiap.enums.Categoria;

public interface FuncionarioDao extends GenericDao<Funcionario, Integer>{

	// busca por parte do nome, retornando uma lista ordenada pelos nomes
	List<Funcionario> buscarPorParteNome(String nome);
	
	// buscar funcionarios admitidos entre duas datas
	List<Funcionario> buscarPorIntervaloTempo(Calendar dt1, Calendar dt2);
	
	//buscar por parte do nome e categoria
	List<Funcionario> buscarPorParteNomeECategoria(String nome, Categoria categoria);
	
	//buscar os 2 primeiros funcionarios pelo nome do hospital
	List<Funcionario> buscar2FuncionariosPeloHospital(String nmHospital);
	
	// buscar quantidade de funcionarios com a mesma idade
	long buscarQtdFuncMesmaIdade(int idade);
	
}
