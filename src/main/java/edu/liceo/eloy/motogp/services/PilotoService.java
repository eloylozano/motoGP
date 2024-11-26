package edu.liceo.eloy.motogp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.liceo.eloy.motogp.model.Piloto;
import edu.liceo.eloy.motogp.repositories.IPilotoRepository;

@Service
public class PilotoService implements IPilotoService {

    @Autowired
    public IPilotoRepository pilotosRepo;

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

    @Override
    public void borrarPiloto(Long id) {
        if (pilotosRepo.existsById(id)) {
            pilotosRepo.deleteById(id);
            System.out.println("Piloto con el id: " + id + " borrado.");
        }
        System.out.println("No se encontró el piloto con el id: " + id);
    }


}
