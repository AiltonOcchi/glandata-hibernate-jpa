package br.com.glandata.model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
	
	public Categoria() {
	}
	
	
	public Categoria(String nome) {
		this.nome = nome;
	}

	public Categoria(Long id) {
		this.id = id;
	}

	@Getter @Setter
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Getter @Setter
	@Basic(optional = false, fetch = FetchType.LAZY)
	private String nome;

	@Override
	public String toString() {
		return "Categoria [id=" + id + ", nome=" + nome + "]";
	}
	
}


