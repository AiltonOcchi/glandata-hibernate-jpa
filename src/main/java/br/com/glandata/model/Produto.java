package br.com.glandata.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(
		name = "produtos", 
		indexes = { @Index(name = "id_produto", columnList = "id")} 
		//,uniqueConstraints = {@UniqueConstraint(name = "nome_unique", columnNames = "nome") }
		)
public class Produto {

	public Produto(String nome, String descricao, BigDecimal preco, Categoria categoria) {
		super();
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
		this.categoria = categoria;
	}

	@Getter @Setter
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Getter @Setter
	private String nome;

	@Getter @Setter
	private String descricao;

	@Getter @Setter
	private BigDecimal preco;
	
	@Getter @Setter
	@Enumerated(EnumType.STRING)
	Categoria categoria;
	
	@Getter @Setter
	@Column(name = "data_cadastro")
	private LocalDate dataCadastro = LocalDate.now();
	
}



