package edu.liceo.eloy.motogp.repositories;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.liceo.eloy.motogp.model.Piloto;

public interface IPilotoRepository extends JpaRepository<Piloto, Long> {

    Optional<Piloto> findByNombre(String nombre);


}
