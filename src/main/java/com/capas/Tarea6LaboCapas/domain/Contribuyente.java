package com.capas.Tarea6LaboCapas.domain;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(schema="public", name="contribuyente")
public class Contribuyente {
	
	@Id
	@Column(name="c_contribuyente")
	@GeneratedValue(strategy=GenerationType.IDENTITY, generator="contribuyente_c_contribuyente_seq")
	private Integer c_contribuyente;
	
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "c_importancia")
	private Importancia c_importancia;
	
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
	
	@Column(name="f_fecha_ingreso")
	private LocalDate f_fecha_ingreso;
	
	public Contribuyente() {};
	
	public Integer getC_contribuyente() {
		return c_contribuyente;
	}
	public void setC_contribuyente(Integer c_contribuyente) {
		this.c_contribuyente = c_contribuyente;
	}
	public Importancia getC_importancia() {
		return c_importancia;
	}
	public void setC_importancia(Importancia c_importancia) {
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
	public LocalDate getF_fecha_ingreso() {
		return f_fecha_ingreso;
	}
	public void setF_fecha_ingreso(LocalDate f_fecha_ingreso) {
		this.f_fecha_ingreso = f_fecha_ingreso;
	}
	
	@PrePersist
	public void prePersist() {
		this.f_fecha_ingreso = LocalDate.now();
	}
	
	public String getFechaDelegate(){
		if(this.f_fecha_ingreso == null){
			return "";
		}
		else{
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			String shortdate = this.f_fecha_ingreso.format(formatter);
			return shortdate;
		}
	}

}
