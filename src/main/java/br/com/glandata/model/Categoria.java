package br.com.glandata.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(
		name = "categorias" 
		//uniqueConstraints = {@UniqueConstraint(name = "nome_unique", columnNames = "nome") }
		)
public class Categoria {
	
	public Categoria(String nome) {
		this.nome = nome;
	}

	@Getter @Setter
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Getter @Setter
	private String nome;
}


