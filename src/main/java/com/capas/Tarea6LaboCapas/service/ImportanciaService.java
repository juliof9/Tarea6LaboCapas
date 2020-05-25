package com.capas.Tarea6LaboCapas.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.capas.Tarea6LaboCapas.domain.Importancia;

public interface ImportanciaService {
	
	public List<Importancia>findAll()throws DataAccessException;

}
