package edu.liceo.eloy.motogp.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import edu.liceo.eloy.motogp.models.Circuito;
import edu.liceo.eloy.motogp.services.ICircuitoService;


@RestController
@RequestMapping("/circuitos")
public class CircuitoController {

    @Autowired
    ICircuitoService circuitoService;

    @GetMapping("/list")
    public List<Circuito> listarCircuitos() {
        return circuitoService.getCircuito();
    }

    @PostMapping("/save")
    public Circuito guardarCircuito(@RequestBody Circuito circuito) {
        return circuitoService.guardarCircuito(circuito);
    }

    @GetMapping("/{id}")
    public Circuito verCircuito(@PathVariable("id") Long id) {
        return circuitoService.buscarCircuito(id);
    }

    @PutMapping("/update/{id}")
    public Circuito actualizarCircuito(@PathVariable("id") Long id, @RequestBody Circuito circuito) {
        if (circuito.getCarreras() == null) {
            circuito.setCarreras(new ArrayList<>());
        }
        circuito.setId(id);
        return circuitoService.actualizarCircuito(circuito);
    }

    @DeleteMapping("/delete/{id}")
    public void eliminarCircuito(@PathVariable("id") Long id) {
        circuitoService.eliminarCircuito(id);
    }

    @GetMapping("/nombre/{nombre}")
    public Circuito getMethodName(@PathVariable("nombre") String nombre) {
        return circuitoService.buscarCircuitoPorNombre(nombre);
    }
    

}
