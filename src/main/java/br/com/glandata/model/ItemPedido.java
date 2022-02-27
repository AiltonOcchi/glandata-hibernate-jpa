package br.com.glandata.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "itens_pedido")
public class ItemPedido {
	
	public ItemPedido() {
	}
	
	public ItemPedido(Long id) {
		super();
		this.id = id;
	}
	
	public ItemPedido(Integer quantidade, Pedido pedido, Produto produto) {
		super();
		this.quantidade = quantidade;
		this.pedido = pedido;
		this.produto = produto;
		this.precoUnitario = produto.getPreco();
	}

	@Getter @Setter
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Getter @Setter
	@Column(name = "preco_unitario")
	private BigDecimal precoUnitario;
	
	@Getter @Setter
	private Integer quantidade;
	
	@Getter @Setter
	@ManyToOne
	private Pedido pedido;
	
	@Getter @Setter
	@ManyToOne
	private Produto produto;

}
