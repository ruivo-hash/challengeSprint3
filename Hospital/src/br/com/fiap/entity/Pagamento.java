package br.com.fiap.entity;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import br.com.fiap.enums.FormaPagamento;

@Entity
@Table(name="TB_PAGAMENTO")
@SequenceGenerator(name="pagamento",sequenceName = "SQ_TB_PAGAMENTO", allocationSize =1)
public class Pagamento {

	@Id
	@Column(name="cd_pagamento")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pagamento")
	private int codigo;
	
	@Column(name="ds_pagamento", nullable = false, length = 30)
	private FormaPagamento pagamento;
	
	@Column(name="vl_pagamento", nullable = false)
	private double valor;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_pagamento", nullable = false, updatable = false)
	private Calendar dtPagamento;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="cd_paciente", nullable = false)
	private Paciente paciente;
	

	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		return "Código: "+ codigo +" Código paciente: "+ paciente +" Forma de Pagamento: "+ pagamento +" Valor: "+ valor+ "Data do pagamento: "+sdf.format(dtPagamento.getTime());
	}
	
	public Pagamento() {}
	public Pagamento( FormaPagamento pagamento, double valor, Paciente paciente) {
		super();
		this.pagamento = pagamento;
		this.valor = valor;
		this.paciente = paciente;
	}
	public Pagamento(int codigo, FormaPagamento pagamento, double valor, Paciente paciente) {
		super();
		this.codigo = codigo;
		this.pagamento = pagamento;
		this.valor = valor;
		this.paciente = paciente;
	}
	public Pagamento(int codigo, FormaPagamento pagamento, double valor, Calendar dtPagamento, Paciente paciente) {
		super();
		this.codigo = codigo;
		this.pagamento = pagamento;
		this.valor = valor;
		this.dtPagamento = dtPagamento;
		this.paciente = paciente;
	}

	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public FormaPagamento getPagamento() {
		return pagamento;
	}
	public void setPagamento(FormaPagamento pagamento) {
		this.pagamento = pagamento;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public Calendar getDtPagamento() {
		return dtPagamento;
	}
	public void setDtPagamento(Calendar dtPagamento) {
		this.dtPagamento = dtPagamento;
	}
	public Paciente getPaciente() {
		return paciente;
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
}