package br.com.fiap.entity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import br.com.fiap.enums.Categoria;

@Entity
@SequenceGenerator(name="funcionario", sequenceName = "SQ_TB_FUNCIONARIO", allocationSize = 1)
@Table(name = "TB_FUNCIONARIO")
public class Funcionario {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "funcionario")
	@Column(name = "cd_funcionario", nullable = false)
	private int codigo;
	
	@Column(name = "nm_funcionario", nullable = false, length = 80)
	private String nome;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "ds_categoria", nullable = false)
	private Categoria categoria;
	
	@Column(name = "nr_registro", length = 7)
	private String registro;
	
	@Column(name = "nr_idade", nullable = false)
	private int idade;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_admissao", updatable = false)
	private Calendar dtAdmissao;
	
	@Column(name = "st_ativo", nullable = false)
	private boolean ativo;
	
	@ManyToMany(mappedBy = "funcionarios")
	private List<Hospital> hospitais;
	

	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		return "Código: "+ codigo +" Nome: "+ nome +" Categoria: "+ categoria +" Registro: "+ registro +" Idade: "+ idade +" Data da Admissão: "+ sdf.format(dtAdmissao.getTime())+" Ativo: "+ ativo;
	}
	
	public Funcionario() {}
	public Funcionario(String nome, Categoria categoria, String registro, int idade, boolean ativo) {
		super();
		this.nome = nome;
		this.categoria = categoria;
		this.registro = registro;
		this.idade = idade;
		this.ativo = ativo;
	}
	public Funcionario(int codigo, String nome, Categoria categoria, String registro, int idade, boolean ativo) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.categoria = categoria;
		this.registro = registro;
		this.idade = idade;
		this.ativo = ativo;
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
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public String getRegistro() {
		return registro;
	}
	public void setRegistro(String registro) {
		this.registro = registro;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public Calendar getDtAdmissao() {
		return dtAdmissao;
	}
	public void setDtAdmissao(Calendar dtAdmissao) {
		this.dtAdmissao = dtAdmissao;
	}
	public boolean isAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	public List<Hospital> getHospitais() {
		return hospitais;
	}
	public void setHospitais(List<Hospital> hospitais) {
		this.hospitais = hospitais;
	}
}
