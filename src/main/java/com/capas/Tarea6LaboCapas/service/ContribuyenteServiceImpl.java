package com.capas.Tarea6LaboCapas.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.capas.Tarea6LaboCapas.dao.ContribuyenteDAO;
import com.capas.Tarea6LaboCapas.domain.Contribuyente;

@Service
public class ContribuyenteServiceImpl implements ContribuyenteService{
	
	@Autowired
	ContribuyenteDAO contribuyenteDAO;

	@Override
	public List<Contribuyente> findAll() throws DataAccessException {
		// TODO Auto-generated method stub
		return contribuyenteDAO.findAll();
	}

	@Override
	@Transactional
	public void save(Contribuyente contribuyente) throws DataAccessException {
		// TODO Auto-generated method stub
		contribuyenteDAO.save(contribuyente);
	}

}
