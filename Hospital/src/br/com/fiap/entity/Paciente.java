package br.com.fiap.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_PACIENTE")
@SequenceGenerator(name="paciente",sequenceName = "SQ_TB_PACIENTE", allocationSize =1)
public class Paciente {

	@Id
	@Column(name="cd_paciente")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "paciente")
	private int codigo;
	
	@Column(name="nm_paciente", nullable = false, length = 80)
	private String nome;
	
	@Column(name="nr_idade", nullable = false, length = 3)
	private int idade;
	
	@Column(name="nr_cpf", nullable = false, length = 14)
	private String cpf;
	
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name="cd_convenio", nullable = false)
	private Convenio convenio;
	
	@OneToMany(mappedBy = "paciente", cascade = CascadeType.PERSIST)
	private List<Pagamento> pagamentos;
	
	@ManyToMany(mappedBy = "pacientes")
	private List<Hospital> hospitais;
	
	public void addPagamento(Pagamento pagamento) {
		if(pagamentos == null)
			pagamentos = new ArrayList<>();
		pagamentos.add(pagamento);
		pagamento.setPaciente(this);
	}
	
	@Override
	public String toString() {
		return "Código: "+ codigo +" Nome: "+ nome +" Idade: "+ idade +" CPF: "+ cpf;
	}
	
	public Paciente() {}
	public Paciente(String nome, int idade, String cpf) {
		super();
		this.nome = nome;
		this.idade = idade;
		this.cpf = cpf;
	}
	public Paciente(int codigo, String nome, int idade, String cpf) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.idade = idade;
		this.cpf = cpf;
	}
	public Paciente(String nome, int idade, String cpf, Convenio convenio) {
		super();
		this.nome = nome;
		this.idade = idade;
		this.cpf = cpf;
		this.convenio = convenio;
	}
	public Paciente(int codigo, String nome, int idade, String cpf, Convenio convenio, List<Pagamento> pagamentos) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.idade = idade;
		this.cpf = cpf;
		this.convenio = convenio;
		this.pagamentos = pagamentos;
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
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public Convenio getConvenio() {
		return convenio;
	}
	public void setConvenio(Convenio convenio) {
		this.convenio = convenio;
	}
}
