package pe.edu.upc.pwspringfinanzas.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.pwspringfinanzas.model.entity.TipoTasa;

@Repository
public interface TipoTasaRepository extends JpaRepository<TipoTasa, Integer>{

}
