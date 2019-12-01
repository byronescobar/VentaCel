package com.parcial2.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="detalleventa")

public class DetalleVenta {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

	@NotEmpty
	@Column(name="cantidad")
	private Integer cantidad;
	
	@NotEmpty
	@Column(name="precio")
	private Double precio;
	
	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Venta.class)
	@JoinColumn(name="idventa")
	private Venta venta;
	
	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Venta.class)
	@JoinColumn(name="idproducto")
	private Producto producto;
	
	public DetalleVenta() {
		// TODO Auto-generated constructor stub
	}

	public DetalleVenta(int id, @NotEmpty Integer cantidad, @NotEmpty Double precio, Venta venta) {
		this.id = id;
		this.cantidad = cantidad;
		this.precio = precio;
		this.venta = venta;
	}
	
	public DetalleVenta(@NotEmpty Integer cantidad, @NotEmpty Double precio, Venta venta) {
		this.cantidad = cantidad;
		this.precio = precio;
		this.venta = venta;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Venta getVenta() {
		return venta;
	}

	public void setVenta(Venta venta) {
		this.venta = venta;
	}

	@Override
	public String toString() {
		return "DetalleVenta [id=" + id + ", cantidad=" + cantidad + ", precio=" + precio + ", venta=" + venta
				+ ", producto=" + producto + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cantidad == null) ? 0 : cantidad.hashCode());
		result = prime * result + id;
		result = prime * result + ((precio == null) ? 0 : precio.hashCode());
		result = prime * result + ((producto == null) ? 0 : producto.hashCode());
		result = prime * result + ((venta == null) ? 0 : venta.hashCode());
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
		DetalleVenta other = (DetalleVenta) obj;
		if (cantidad == null) {
			if (other.cantidad != null)
				return false;
		} else if (!cantidad.equals(other.cantidad))
			return false;
		if (id != other.id)
			return false;
		if (precio == null) {
			if (other.precio != null)
				return false;
		} else if (!precio.equals(other.precio))
			return false;
		if (producto == null) {
			if (other.producto != null)
				return false;
		} else if (!producto.equals(other.producto))
			return false;
		if (venta == null) {
			if (other.venta != null)
				return false;
		} else if (!venta.equals(other.venta))
			return false;
		return true;
	}

}
