package edu.liceo.eloy.motogp.controllers;

import java.util.Set;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import edu.liceo.eloy.motogp.controllers.DTO.PilotoDTO;
import edu.liceo.eloy.motogp.models.Piloto;
import edu.liceo.eloy.motogp.models.enumerated.Conduccion;
import edu.liceo.eloy.motogp.services.IPilotoService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pilotos")
public class PilotoController {

    @Autowired
    IPilotoService pilotoService;

    @GetMapping("/list")
    public ResponseEntity<List<PilotoDTO>> getListaPilotos() {
        return ResponseEntity.status(HttpStatus.FOUND).body(pilotoService.getListaPilotos());
    }

    @PostMapping("/save")
    public ResponseEntity<PilotoDTO> guardarPiloto(@RequestBody Piloto pi) {
        PilotoDTO pilotoRegistrado = pilotoService.guardarPiloto(pi);
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PilotoDTO> getPilotoId(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(pilotoService.getPilotoId(id));
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

    @GetMapping("/maslaureado")
    public Piloto masLaureado() {
        return pilotoService.mayorVictorias();
    }

    @GetMapping("/conduccion/{estilo}")
    public ResponseEntity<List<PilotoDTO>> getPilotosPorEstilo(@PathVariable("estilo") Conduccion conduccion) {
        List<PilotoDTO> pilotosDTO = pilotoService.getPilotoByEstilo(conduccion);

        if (pilotosDTO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); // Devuelve 404 si no hay pilotos.
        }

        return ResponseEntity.ok(pilotosDTO); // Devuelve 200 OK con la lista de DTOs.
    }

}
