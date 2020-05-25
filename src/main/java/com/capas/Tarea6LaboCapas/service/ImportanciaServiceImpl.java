package com.capas.Tarea6LaboCapas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.capas.Tarea6LaboCapas.dao.ImportanciaDAO;
import com.capas.Tarea6LaboCapas.domain.Importancia;

@Service
public class ImportanciaServiceImpl implements ImportanciaService{
	
	@Autowired
	ImportanciaDAO importanciaDAO;

	@Override
	public List<Importancia> findAll() throws DataAccessException {
		return importanciaDAO.findAll();
	}

}
