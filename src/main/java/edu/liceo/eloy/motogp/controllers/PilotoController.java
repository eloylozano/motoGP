package edu.liceo.eloy.motogp.controllers;

import java.util.Set;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import edu.liceo.eloy.motogp.model.Piloto;
import edu.liceo.eloy.motogp.services.IPilotoService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pilotos")
public class PilotoController {

    @Autowired
    IPilotoService pilotoService;

    @GetMapping("/list")
    public List<Piloto> listarPilotos() {
        return pilotoService.getPiloto();
    }

    @PostMapping("/save")
    public Piloto guardarPiloto(@RequestBody Piloto piloto) {
        return pilotoService.guardarPiloto(piloto);
    }

    @GetMapping("/{id}")
    public Piloto verPiloto(@PathVariable("id") Long id) {
        return pilotoService.buscarPiloto(id);
    }

    @PutMapping("/update")
    public Piloto actualizarPiloto(@RequestBody Piloto piloto) {
        return pilotoService.actualizarPiloto(piloto);
    }

    @DeleteMapping("/delete/{id}")
    public void borrarPiloto(@PathVariable("id") Long id) {
        pilotoService.borrarPiloto(id);
    }

    @GetMapping("/podium")
    public Set<Piloto> getPilotosEnPodium() {
        return pilotoService.pilotosConPodium();  
    }

}
