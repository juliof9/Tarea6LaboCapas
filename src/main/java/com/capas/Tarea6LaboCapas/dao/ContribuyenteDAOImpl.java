package com.capas.Tarea6LaboCapas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.capas.Tarea6LaboCapas.domain.Contribuyente;

@Repository
public class ContribuyenteDAOImpl implements ContribuyenteDAO{
	
	@PersistenceContext(unitName="Tarea6LaboCapas")
	private EntityManager entitytManager;

	@Override
	public List<Contribuyente> findAll() throws DataAccessException {
		StringBuffer sb = new StringBuffer();
		sb.append("select * from public.contribuyente");
		Query query = entitytManager.createNativeQuery(sb.toString(), Contribuyente.class);
		List<Contribuyente>resulset=query.getResultList();
		return resulset;
	}

	@Override
	@Transactional
	public void save(Contribuyente contribuyente) throws DataAccessException {
		// TODO Auto-generated method stub
		entitytManager.persist(contribuyente);
	}

}
