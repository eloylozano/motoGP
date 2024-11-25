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
        if (!op.isPresent()) {
            System.out.println("Piloto no encontrado");
            return null;
        } else {
            System.out.println("Piloto borrado con éxito!");
            return op.get();
        }
    }

    @Override
    public Piloto actualiazrPiloto(Piloto piloto) {
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
    public Piloto borrarPiloto(Long id) {
        Optional<Piloto> op = pilotosRepo.findById(id);
        if (!op.isPresent()) {
            System.out.println("Piloto no encontrado. No se pudo borrar!");
            return null;
        } else {
            System.out.println("Se ha borrado el piloto con el id: " + id);
            pilotosRepo.deleteById(id);
            return op.get();
        }
    }


}
