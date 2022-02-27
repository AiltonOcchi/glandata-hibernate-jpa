package br.com.glandata.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "pedidos")
public class Pedido {
	
	public Pedido() {
	}
	
	public Pedido(Cliente cliente) {
		this.cliente = cliente;
	}
	
	@Getter @Setter
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Getter @Setter
	@Column(name = "valor_total")
	private BigDecimal valorTotal;
	
	@Getter @Setter
	private LocalDate data = LocalDate.now();

	@Getter @Setter
	@ManyToOne
	private Cliente cliente;
	
	@Getter @Setter
	@OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
	private List<ItemPedido> itens = new ArrayList<>();
	
	public void adicionarItem(ItemPedido item) {
		item.setPedido(this);
		this.itens.add(item);
		
	}
	
	
}

