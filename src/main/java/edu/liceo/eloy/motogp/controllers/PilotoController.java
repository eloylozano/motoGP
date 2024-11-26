package edu.liceo.eloy.motogp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import edu.liceo.eloy.motogp.model.Piloto;
import edu.liceo.eloy.motogp.services.IPilotoService;
import org.springframework.web.bind.annotation.*;

@RestController
public class PilotoController {

    @Autowired
    IPilotoService pilotoService;

    @GetMapping("/pilotos")
    public List<Piloto> listarPilotos() {
        return pilotoService.getPiloto();
    }

    @PostMapping("/pilotos/save")
    public Piloto guardarPiloto(@RequestBody Piloto piloto) {
        return pilotoService.guardarPiloto(piloto);
    }

    @GetMapping("/pilotos/{id}")
    public Piloto verPiloto(@PathVariable("id") Long id) {
        return pilotoService.buscarPiloto(id);
    }

    @PutMapping("/actualizarpiloto")
    public Piloto actualizarPiloto(@RequestBody Piloto piloto) {
        return pilotoService.actualizarPiloto(piloto);
    }

    @DeleteMapping("/eliminarpiloto/{id}")
    public void borrarPiloto(@PathVariable("id") Long id) {
        pilotoService.borrarPiloto(id);
    }

}
