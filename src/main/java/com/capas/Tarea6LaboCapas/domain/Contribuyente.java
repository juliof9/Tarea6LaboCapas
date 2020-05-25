package com.capas.Tarea6LaboCapas.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(schema="public", name="contribuyente")
public class Contribuyente {
	
	@Id
	@Column(name="c_contribuyente")
	@GeneratedValue(strategy=GenerationType.IDENTITY, generator="contribuyente_c_contribuyente_seq")
	private Integer c_contribuyente;
	
	@Column(name="c_importancia")
	@OneToMany(mappedBy="contribuyente", fetch=FetchType.EAGER)
	private Integer c_importancia;
	
	@NotNull(message="No puede estar vacio")
	@Size(min=1,max=30, message="No puede contener mas de 30 digitos")
	@Column(name="s_nombre")
	private String s_nombre;
	
	@NotNull(message="No puede estar vacio")
	@Size(min=1, max=30, message="No puede contener mas de 30 digitos")
	@Column(name="s_apellido")
	private String s_apellido;
	
	@NotNull(message="No puede estar vacio")
	@Column(name="s_nit")
	@Size(min=14, max=14, message="Deben de ser 14 digitos")
	private String s_nit;
	
	@NotNull(message="No puede estar vacio")
	@Pattern(regexp="^(?:3[01]|[12][0-9]|0?[1-9])([\\-/.])(0?[1-9]|1[1-2])\\1\\d{4}$", 
			message="La fecha tiene que seguir el siguiente formato: (dd-mm-yyyy)")
	@Column(name="f_fecha_ingreso")
	private Date f_fecha_ingreso;
	
	public Contribuyente() {};
	
	public Integer getC_contribuyente() {
		return c_contribuyente;
	}
	public void setC_contribuyente(Integer c_contribuyente) {
		this.c_contribuyente = c_contribuyente;
	}
	public Integer getC_importancia() {
		return c_importancia;
	}
	public void setC_importancia(Integer c_importancia) {
		this.c_importancia = c_importancia;
	}
	public String getS_nombre() {
		return s_nombre;
	}
	public void setS_nombre(String s_nombre) {
		this.s_nombre = s_nombre;
	}
	public String getS_apellido() {
		return s_apellido;
	}
	public void setS_apellido(String s_apellido) {
		this.s_apellido = s_apellido;
	}
	public String getS_nit() {
		return s_nit;
	}
	public void setS_nit(String s_nit) {
		this.s_nit = s_nit;
	}
	public Date getF_fecha_ingreso() {
		return f_fecha_ingreso;
	}
	public void setF_fecha_ingreso(Date f_fecha_ingreso) {
		this.f_fecha_ingreso = f_fecha_ingreso;
	}

}
