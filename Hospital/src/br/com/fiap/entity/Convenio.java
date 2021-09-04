package br.com.fiap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.com.fiap.enums.TipoConvenio;

@Entity
@SequenceGenerator(name="convenio", sequenceName = "SQ_TB_CONVENIO", allocationSize = 1)
@Table(name = "TB_CONVENIO")
public class Convenio {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "convenio")
	@Column(name = "cd_convenio", nullable = false)
	private int codigo;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "ds_convenio", nullable = false)
	private TipoConvenio convenio;
	
	@OneToOne(mappedBy = "convenio")
	private Paciente pacientes;
	
	@Override
	public String toString() {
		return "Código: "+ codigo +" Convênio: "+ convenio ;
	}
	
	public Convenio() {}
	public Convenio(TipoConvenio convenio) {
		super();
		this.convenio = convenio;
	}
	public Convenio(int codigo, TipoConvenio convenio) {
		super();
		this.codigo = codigo;
		this.convenio = convenio;
	}
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public TipoConvenio getConvenio() {
		return convenio;
	}
	public void setConvenio(TipoConvenio convenio) {
		this.convenio = convenio;
	}
	public Paciente getPacientes() {
		return pacientes;
	}
	public void setPacientes(Paciente pacientes) {
		this.pacientes = pacientes;
	}
}
