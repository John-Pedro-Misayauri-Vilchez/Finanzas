package pe.edu.upc.pwspringfinanzas.service.crud.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import pe.edu.upc.pwspringfinanzas.model.entity.PlazoTasa;
import pe.edu.upc.pwspringfinanzas.model.repository.PlazoTasaRepository;
import pe.edu.upc.pwspringfinanzas.service.crud.PlazoTasaService;

public class PlazoTasaServiceImpl implements PlazoTasaService{

	@Autowired
	private PlazoTasaRepository plazoTasaRepository;
	
	@Override
	public JpaRepository<PlazoTasa, Integer> getRepository() {
		return plazoTasaRepository;
	}

}
