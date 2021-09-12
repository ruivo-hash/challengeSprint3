package br.com.fiap.cadastrotutor.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Entity
public class Tutor {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	@NotBlank(message = "Campo Nome obrigatório")
	private String name;
	
	@NotBlank(message = "Insira um email válido")
	private String email;
	
	private String pass;
}
