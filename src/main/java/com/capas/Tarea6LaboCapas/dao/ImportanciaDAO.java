package com.capas.Tarea6LaboCapas.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.capas.Tarea6LaboCapas.domain.Importancia;

public interface ImportanciaDAO {
	
	public List<Importancia>findAll()throws DataAccessException;

}
