package br.com.fiap.dao;

import java.util.List;

import br.com.fiap.entity.Pagamento;

public interface PagamentoDao extends GenericDao<Pagamento, Integer>{

	// buscar os 2 primeiros pagamentos de um paciente, pelo nome do paciente
	List<Pagamento> buscar2Pagamentos(String nome);
}
