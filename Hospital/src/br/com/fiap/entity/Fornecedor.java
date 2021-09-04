package br.com.fiap.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.com.fiap.enums.ProdutoFornecido;

@Entity
@SequenceGenerator(name="fornecedor", sequenceName = "SQ_TB_FORNECEDOR", allocationSize = 1)
@Table(name = "TB_FORNECEDOR")
public class Fornecedor {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fornecedor")
	@Column(name = "cd_fornecedor", nullable = false)
	private int codigo;
	
	@Column(name="nm_fornecedor", nullable = false, length = 50)
	private String nome;
	
	@Column(name="nr_cnpj", nullable = false, length = 18)
	private String cnpj;
	
	@Enumerated(EnumType.STRING)
	@Column(name="nm_produto", nullable = false, length = 40)
	private ProdutoFornecido produto;
	
	@Column(name="ds_contato", nullable = false, length = 30)
	private String contato;
	
	@ManyToMany(mappedBy = "fornecedores")
	private List<Hospital> hospitais;
	
	@Override
	public String toString() {
		return "Código: "+ codigo +" Nome: "+ nome +" CNPJ: "+ cnpj +" Produto: "+ produto+" Contato: "+ contato;
	}
	
	public Fornecedor() {}
	public Fornecedor(String nome, String cnpj, ProdutoFornecido produto, String contato) {
		super();
		this.nome = nome;
		this.cnpj = cnpj;
		this.produto = produto;
		this.contato = contato;
	}
	public Fornecedor(String nome, String cnpj, ProdutoFornecido produto, String contato, List<Hospital> hospitais) {
		super();
		this.nome = nome;
		this.cnpj = cnpj;
		this.produto = produto;
		this.contato = contato;
		this.hospitais = hospitais;
	}
	public Fornecedor(int codigo, String nome, String cnpj, ProdutoFornecido produto, String contato) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.cnpj = cnpj;
		this.produto = produto;
		this.contato = contato;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public ProdutoFornecido getProduto() {
		return produto;
	}
	public void setProduto(ProdutoFornecido produto) {
		this.produto = produto;
	}
	public String getContato() {
		return contato;
	}
	public void setContato(String contato) {
		this.contato = contato;
	}
	public List<Hospital> getHospitais() {
		return hospitais;
	}
	public void setHospitais(List<Hospital> hospitais) {
		this.hospitais = hospitais;
	}
}
