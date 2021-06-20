package pe.edu.upc.pwspringfinanzas.service.crud.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.pwspringfinanzas.model.entity.TipoTasa;
import pe.edu.upc.pwspringfinanzas.model.repository.TipoTasaRepository;
import pe.edu.upc.pwspringfinanzas.service.crud.TipoTasaService;

@Service
public class TipoTasaServiceImpl implements TipoTasaService {

	@Autowired
	private TipoTasaRepository tipoTasaRepository;

	@Override
	public JpaRepository<TipoTasa, Integer> getRepository() {
		return tipoTasaRepository;
	}

}
