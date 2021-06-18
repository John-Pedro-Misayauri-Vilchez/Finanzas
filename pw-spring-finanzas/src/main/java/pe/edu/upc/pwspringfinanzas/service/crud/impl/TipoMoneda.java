package pe.edu.upc.pwspringfinanzas.service.crud.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import pe.edu.upc.pwspringfinanzas.model.repository.TipoMonedaRepository;
import pe.edu.upc.pwspringfinanzas.service.crud.TipoMonedaService;

public class TipoMoneda implements TipoMonedaService{

	@Autowired
	private TipoMonedaRepository tipoMonedaRepository;
	
	@Override
	public JpaRepository<pe.edu.upc.pwspringfinanzas.model.entity.TipoMoneda, Integer> getRepository() {
		return tipoMonedaRepository;
	}

}
