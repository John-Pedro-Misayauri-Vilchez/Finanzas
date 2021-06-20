package pe.edu.upc.pwspringfinanzas.service.crud.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.pwspringfinanzas.model.entity.Cliente;
import pe.edu.upc.pwspringfinanzas.model.repository.ClienteRepository;
import pe.edu.upc.pwspringfinanzas.service.crud.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService{

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Override
	public JpaRepository<Cliente, Integer> getRepository() {
		return clienteRepository;
	}

}
