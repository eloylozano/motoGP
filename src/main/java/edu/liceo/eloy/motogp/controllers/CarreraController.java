package edu.liceo.eloy.motogp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import edu.liceo.eloy.motogp.model.Carrera;
import edu.liceo.eloy.motogp.services.ICarreraService;
import org.springframework.web.bind.annotation.*;

@RestController
public class CarreraController {

    @Autowired
    ICarreraService carreraService;

    @GetMapping("/carreras")
    public List<Carrera> verCarreras() {
        return carreraService.getCarreras();
    }

    @GetMapping("/carreras/{id}")
    public Carrera encontrarCarrera(@PathVariable("id") Long id) {
        return carreraService.buscarCarrera(id);
    }

    @PostMapping("/carreras/save")
    public Carrera agregarCarrera(@RequestBody Carrera carrera) {
        return carreraService.guardarCarrera(carrera);
    }

    @PutMapping("/actualizarcarrera")
    public Carrera cambiarCarrera(@RequestBody Carrera carrera) {
        return carreraService.actualizarCarrera(carrera);
    }

    @DeleteMapping("/borrarCarrera/{id}")
    public void eliminarCarrera(@PathVariable("id") Long id) {
        carreraService.borrarCarreras(id);
    }
}
