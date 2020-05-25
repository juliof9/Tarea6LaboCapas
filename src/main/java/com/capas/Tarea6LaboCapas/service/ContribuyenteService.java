package com.capas.Tarea6LaboCapas.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.capas.Tarea6LaboCapas.domain.Contribuyente;

public interface ContribuyenteService {
	
	public List<Contribuyente>findAll()throws DataAccessException;
	
	public void save(Contribuyente contribuyente)throws DataAccessException;

}
