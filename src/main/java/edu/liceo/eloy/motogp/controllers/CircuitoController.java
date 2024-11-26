package edu.liceo.eloy.motogp.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import edu.liceo.eloy.motogp.model.Circuito;
import edu.liceo.eloy.motogp.services.ICircuitoService;

@RestController
public class CircuitoController {

    @Autowired
    ICircuitoService circuitoService;

    @GetMapping("/circuitos")
    public List<Circuito> listarCircuitos() {
        return circuitoService.getCircuito();
    }

    @PostMapping("/circuitos/save")
    public Circuito guardarCircuito(@RequestBody Circuito circuito) {
        return circuitoService.guardarCircuito(circuito);
    }

    @GetMapping("/circuitos/{id}")
    public Circuito verCircuito(@PathVariable("id") Long id) {
        return circuitoService.buscarCircuito(id);
    }

    @PutMapping("/actualizarcircuito/{id}")
    public Circuito actualizarCircuito(@PathVariable("id") Long id, @RequestBody Circuito circuito) {
        if (circuito.getCarreras() == null) {
            circuito.setCarreras(new ArrayList<>());
        }
        circuito.setId(id);
        return circuitoService.actualizarCircuito(circuito);
    }

    @DeleteMapping("/eliminarcircuito/{id}")
    public void eliminarCircuito(@PathVariable("id") Long id) {
        circuitoService.eliminarCircuito(id);
    }

}
