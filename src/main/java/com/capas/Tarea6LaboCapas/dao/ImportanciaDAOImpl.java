package com.capas.Tarea6LaboCapas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.capas.Tarea6LaboCapas.domain.Importancia;

@Repository
public class ImportanciaDAOImpl implements ImportanciaDAO{
	
	@PersistenceContext(unitName="Tarea6LaboCapas")
	private EntityManager entityManager;

	@Override
	public List<Importancia> findAll() throws DataAccessException {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		sb.append("select * from public.importancia");
		Query query = entityManager.createNativeQuery(sb.toString(), Importancia.class);
		List<Importancia>resulset=query.getResultList();
		return resulset;
	}

}
