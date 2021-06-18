package pe.edu.upc.pwspringfinanzas.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.pwspringfinanzas.model.entity.PlazoTasa;

@Repository
public interface PlazoTasaRepository extends JpaRepository<PlazoTasa, Integer>{

}
