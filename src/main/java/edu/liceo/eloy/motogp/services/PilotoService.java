package edu.liceo.eloy.motogp.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.liceo.eloy.motogp.model.Carrera;
import edu.liceo.eloy.motogp.model.Piloto;
import edu.liceo.eloy.motogp.repositories.ICarreraRepository;
import edu.liceo.eloy.motogp.repositories.IPilotoRepository;
import jakarta.transaction.Transactional;

@Service
public class PilotoService implements IPilotoService {

    @Autowired
    IPilotoRepository pilotosRepo;
    @Autowired
    ICarreraRepository carrerasRepo;

    @Override
    public List<Piloto> getPiloto() {
        return pilotosRepo.findAll();
    }

    @Override
    public Piloto guardarPiloto(Piloto piloto) {
        return pilotosRepo.save(piloto);
    }

    @Override
    public Piloto buscarPiloto(Long id) {
        Optional<Piloto> op = pilotosRepo.findById(id);
        if (op.isPresent()) {
            System.out.println("Piloto encontrado con éxito!");
            return op.get();
            
        } else {
            System.out.println("Piloto no encontrado");
            return null;
        }
    }

    @Override
    public Piloto actualizarPiloto(Piloto piloto) {
        Optional<Piloto> pilotoExistente = pilotosRepo.findByNombre(piloto.getNombre());
        if (pilotoExistente.isPresent()) {
            Piloto pilotoActualizado = pilotoExistente.get();
            pilotoActualizado.setNombre(piloto.getNombre());
            pilotoActualizado.setConduccion(piloto.getConduccion());
            return pilotosRepo.save(pilotoActualizado);

        } else {
            return pilotosRepo.save(piloto);
        }
    }

    @Transactional
    @Override
    public void borrarPiloto(Long id) {
        if (pilotosRepo.existsById(id)) {
            pilotosRepo.deleteById(id);
            System.out.println("Piloto con el id: " + id + " borrado.");
        }
        System.out.println("No se encontró el piloto con el id: " + id);
    }

    @Override
    public Set<Piloto> pilotosConPodium() {
        List<Carrera> carrerasPodium = carrerasRepo.findByPosicionBetween(1, 3);
        Set<Piloto> pilotosPodium = new HashSet<>();

        for (Carrera carrera : carrerasPodium) {
            pilotosPodium.add(carrera.getPiloto());
        }
        return pilotosPodium;
    }



}
