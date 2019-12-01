package com.parcial2.entidades;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="venta")

public class Venta {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@NotEmpty
	@Column(name="iva")
	private Double iva;
	
	@NotEmpty
	@Column(name="subtotal")
	private Double subtotal;
	
	@NotEmpty
	@Column(name="total")
	private Double total;
	
	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Cliente.class)
	@JoinColumn(name="idcliente")
	private Cliente cliente;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy="venta", cascade= CascadeType.ALL)
	private List<DetalleVenta> listventa= new ArrayList<DetalleVenta>();
	
	public Venta() {
		// TODO Auto-generated constructor stub
	}
	
	public Venta(int id, @NotEmpty Double iva, @NotEmpty Double subtotal, @NotEmpty Double total, Cliente cliente,
			List<DetalleVenta> listventa) {
		this.id = id;
		this.iva = iva;
		this.subtotal = subtotal;
		this.total = total;
		this.cliente = cliente;
		this.listventa = listventa;
	}
	
	public Venta(@NotEmpty Double iva, @NotEmpty Double subtotal, @NotEmpty Double total, Cliente cliente,
			List<DetalleVenta> listventa) {
		this.iva = iva;
		this.subtotal = subtotal;
		this.total = total;
		this.cliente = cliente;
		this.listventa = listventa;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Double getIva() {
		return iva;
	}

	public void setIva(Double iva) {
		this.iva = iva;
	}

	public Double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<DetalleVenta> getListventa() {
		return listventa;
	}

	public void setListventa(List<DetalleVenta> listventa) {
		this.listventa = listventa;
	}

	@Override
	public String toString() {
		return "Venta [id=" + id + ", iva=" + iva + ", subtotal=" + subtotal + ", total=" + total + ", cliente="
				+ cliente + ", listventa=" + listventa + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
		result = prime * result + id;
		result = prime * result + ((iva == null) ? 0 : iva.hashCode());
		result = prime * result + ((listventa == null) ? 0 : listventa.hashCode());
		result = prime * result + ((subtotal == null) ? 0 : subtotal.hashCode());
		result = prime * result + ((total == null) ? 0 : total.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Venta other = (Venta) obj;
		if (cliente == null) {
			if (other.cliente != null)
				return false;
		} else if (!cliente.equals(other.cliente))
			return false;
		if (id != other.id)
			return false;
		if (iva == null) {
			if (other.iva != null)
				return false;
		} else if (!iva.equals(other.iva))
			return false;
		if (listventa == null) {
			if (other.listventa != null)
				return false;
		} else if (!listventa.equals(other.listventa))
			return false;
		if (subtotal == null) {
			if (other.subtotal != null)
				return false;
		} else if (!subtotal.equals(other.subtotal))
			return false;
		if (total == null) {
			if (other.total != null)
				return false;
		} else if (!total.equals(other.total))
			return false;
		return true;
	}

	
	
}
