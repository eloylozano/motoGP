package edu.liceo.eloy.motogp.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import edu.liceo.eloy.motogp.repositories.ICircuitoRepository;

@RestController
public class CircutioController {

    @Autowired
    public ICircuitoRepository circuitoRepo;

    

}
