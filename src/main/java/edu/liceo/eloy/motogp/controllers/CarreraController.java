package edu.liceo.eloy.motogp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import edu.liceo.eloy.motogp.models.Carrera;
import edu.liceo.eloy.motogp.services.ICarreraService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("carreras")
public class CarreraController {

    @Autowired
    ICarreraService carreraService;

    @GetMapping("/list")
    public List<Carrera> verCarreras() {
        return carreraService.getCarreras();
    }

    @GetMapping("/{id}")
    public Carrera encontrarCarrera(@PathVariable("id") Long id) {
        return carreraService.buscarCarrera(id);
    }

    @PostMapping("/save")
    public Carrera agregarCarrera(@RequestBody Carrera carrera) {
        return carreraService.guardarCarrera(carrera);
    }

    @PutMapping("/update")
    public Carrera cambiarCarrera(@RequestBody Carrera carrera) {
        return carreraService.actualizarCarrera(carrera);
    }

    @DeleteMapping("/delete/{id}")
    public void eliminarCarrera(@PathVariable("id") Long id) {
        carreraService.borrarCarreras(id);
    }

    @GetMapping("/podiums")
    public List<Carrera> getPilotosEnPodium() {
        return carreraService.verPodiums();  
    }
    
}
