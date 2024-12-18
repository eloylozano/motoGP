package edu.liceo.eloy.motogp.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import edu.liceo.eloy.motogp.model.Carrera;
import edu.liceo.eloy.motogp.model.Piloto;

public interface ICarreraRepository extends JpaRepository<Carrera,Long>{

    List<Carrera> findByPosicionBetween(Integer posicion1, Integer posicion2);

    List<Carrera> findByPosicion (Integer posicion);
}
