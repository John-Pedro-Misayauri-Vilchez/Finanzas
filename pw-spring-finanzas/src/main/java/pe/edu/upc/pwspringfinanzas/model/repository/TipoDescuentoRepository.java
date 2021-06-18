package pe.edu.upc.pwspringfinanzas.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.pwspringfinanzas.model.entity.TipoDescuento;

@Repository
public interface TipoDescuentoRepository extends JpaRepository<TipoDescuento, Integer>{

}
