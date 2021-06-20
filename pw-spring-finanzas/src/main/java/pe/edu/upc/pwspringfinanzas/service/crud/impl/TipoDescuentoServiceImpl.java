package pe.edu.upc.pwspringfinanzas.service.crud.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.pwspringfinanzas.model.entity.TipoDescuento;
import pe.edu.upc.pwspringfinanzas.model.repository.TipoDescuentoRepository;
import pe.edu.upc.pwspringfinanzas.service.crud.TipoDescuentoService;

@Service
public class TipoDescuentoServiceImpl implements TipoDescuentoService{

	@Autowired
	private TipoDescuentoRepository tipoDescuentoRepository;

	@Override
	public JpaRepository<TipoDescuento, Integer> getRepository() {
		return tipoDescuentoRepository;
	}

}
