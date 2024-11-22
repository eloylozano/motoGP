package edu.liceo.eloy.motogp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.liceo.eloy.motogp.model.Piloto;

public interface IPilotoRepository extends JpaRepository<Piloto, Long> {

}
