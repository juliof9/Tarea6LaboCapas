package com.capas.Tarea6LaboCapas.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(schema="public", name="importancia")
public class Importancia {
	
	@Id
	@Column(name="c_importancia")
	@GeneratedValue(strategy=GenerationType.AUTO, generator="importancia_c_importancia_seq")
	private Integer c_importancia;
	
	@Column(name="s_importancia")
	private String s_importancia;
	
    @OneToMany(mappedBy = "importancia", fetch = FetchType.LAZY)
	private List<Contribuyente> contribuyentes;
    
	public Importancia() {};
	
	public List<Contribuyente> getContribuyentes() {
		return contribuyentes;
	}

	public void setContribuyentes(List<Contribuyente> contribuyentes) {
		this.contribuyentes = contribuyentes;
	}
	
	public Integer getC_importancia() {
		return c_importancia;
	}
	public void setC_importancia(Integer c_importancia) {
		this.c_importancia = c_importancia;
	}
	public String getS_importancia() {
		return s_importancia;
	}
	public void setS_importancia(String s_importancia) {
		this.s_importancia = s_importancia;
	}
	
	

}
