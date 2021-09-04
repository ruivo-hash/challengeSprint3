package br.com.fiap.entity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@SequenceGenerator(name="hospital", sequenceName = "SQ_TB_HOSPITAL", allocationSize = 1)
@Table(name = "TB_HOSPITAL")
public class Hospital {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hospital")
	@Column(name = "cd_hospital", nullable = false)
	private int codigo;
	
	@Column(name = "nm_hospital", nullable = false, length = 80)
	private String nome;
	
	@Column(name = "nr_cnpj", nullable = false, length = 18)
	private String cnpj;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_construcao", updatable = false)
	private Calendar dtConstrucao;
	
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "TB_HOSPITAL_PACIENTE", joinColumns = @JoinColumn(name = "cd_hospital", nullable = false), inverseJoinColumns = @JoinColumn(name = "cd_paciente", nullable = false))
	private List<Paciente> pacientes;
	
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "TB_HOSPITAL_FORNEC", joinColumns = @JoinColumn(name = "cd_hospital", nullable = false), inverseJoinColumns = @JoinColumn(name = "cd_fornecedor", nullable = false))
	private List<Fornecedor> fornecedores;
	
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "TB_HOSPITAL_FUNC", joinColumns = @JoinColumn(name = "cd_hospital", nullable = false), inverseJoinColumns = @JoinColumn(name = "cd_funcionario", nullable = false))
	private List<Funcionario> funcionarios;
	

	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		return "Código: "+ codigo +" Nome: "+ nome +" CNPJ: "+ cnpj +" Data da Construção: "+ sdf.format(dtConstrucao.getTime());
	}
	
	public Hospital() {}
	public Hospital(String nome, String cnpj) {
		super();
		this.nome = nome;
		this.cnpj = cnpj;
	}
	public Hospital(int codigo, String nome, String cnpj) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.cnpj = cnpj;
	}
	public Hospital(String nome, String cnpj, 
			List<Paciente> pacientes, List<Fornecedor> fornecedores, List<Funcionario> funcionarios) {
		super();
		this.nome = nome;
		this.cnpj = cnpj;
		this.pacientes = pacientes;
		this.fornecedores = fornecedores;
		this.funcionarios = funcionarios;
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
	public Calendar getDtConstrucao() {
		return dtConstrucao;
	}
	public void setDtConstrucao(Calendar dtConstrucao) {
		this.dtConstrucao = dtConstrucao;
	}
	public List<Paciente> getPacientes() {
		return pacientes;
	}
	public void setPacientes(List<Paciente> pacientes) {
		this.pacientes = pacientes;
	}
	public List<Fornecedor> getFornecedores() {
		return fornecedores;
	}
	public void setFornecedores(List<Fornecedor> fornecedores) {
		this.fornecedores = fornecedores;
	}
	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}
	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}
}