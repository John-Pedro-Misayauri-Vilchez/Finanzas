package pe.edu.upc.pwspringfinanzas.service.crud.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.pwspringfinanzas.model.entity.Cartera;
import pe.edu.upc.pwspringfinanzas.model.repository.CarteraRepository;
import pe.edu.upc.pwspringfinanzas.service.crud.CarteraService;

@Service
public class CarteraServiceImpl implements CarteraService {

	@Autowired
	private CarteraRepository carteraRepository;

	@Override
	public JpaRepository<Cartera, Integer> getRepository() {
		return carteraRepository;
	}

}
