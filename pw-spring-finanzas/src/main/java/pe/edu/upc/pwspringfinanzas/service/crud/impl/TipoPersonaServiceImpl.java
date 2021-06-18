package pe.edu.upc.pwspringfinanzas.service.crud.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import pe.edu.upc.pwspringfinanzas.model.entity.TipoPersona;
import pe.edu.upc.pwspringfinanzas.model.repository.TipoPersonaRepository;
import pe.edu.upc.pwspringfinanzas.service.crud.TipoPersonaService;

public class TipoPersonaServiceImpl implements TipoPersonaService{

	@Autowired
	private TipoPersonaRepository tipoPersonaRepository;
	
	@Override
	public JpaRepository<TipoPersona, Integer> getRepository() {
		return tipoPersonaRepository;
	}

}
