package br.com.glandata.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(
		name = "produtos", 
		indexes = { @Index(name = "id_produto", columnList = "id")}, 
		uniqueConstraints = {@UniqueConstraint(name = "nome_unique", columnNames = "nome") }
		)
public class Produto {

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

}