package edu.liceo.eloy.motogp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.liceo.eloy.motogp.model.Circuito;

public interface ICircuitoRepository extends JpaRepository<Circuito, Long> {

}