package edu.liceo.eloy.motogp.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.liceo.eloy.motogp.model.Circuito;
import edu.liceo.eloy.motogp.model.Piloto;

public interface ICircuitoRepository extends JpaRepository<Circuito, Long> {

    Optional<Circuito> findByNombre(String nombre);

}
