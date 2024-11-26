package edu.liceo.eloy.motogp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.liceo.eloy.motogp.model.Carrera;
import edu.liceo.eloy.motogp.model.Circuito;
import edu.liceo.eloy.motogp.repositories.ICircuitoRepository;

@Service
public class CircuitoService implements ICircuitoService {

    @Autowired
    public ICircuitoRepository circuitoRepo;

    @Override
    public List<Circuito> getCircuito() {
        return circuitoRepo.findAll();
    }

    @Override
    public Circuito guardarCircuito(Circuito circuito) {
        System.out.println("Circuito guardado!");
        return circuitoRepo.save(circuito);
    }

    @Override
    public Circuito actualizarCircuito(Circuito circuito) {
        Optional<Circuito> circuitoExistente = circuitoRepo.findById(circuito.getId());

        if (circuitoExistente.isPresent()) {
            Circuito circuitoActualizado = circuitoExistente.get();
            circuitoActualizado.setNombre(circuito.getNombre());
            circuitoActualizado.setLocalidad(circuito.getLocalidad());
            for (Carrera carrera : circuito.getCarreras()) {
                carrera.setCircuito(circuitoActualizado);
            }
            return circuitoRepo.save(circuitoActualizado);
        } else {
            return circuitoRepo.save(circuito); 
        }
    }

    @Override
    public Circuito buscarCircuito(Long id) {
        Optional<Circuito> op = circuitoRepo.findById(id);
        if (!op.isPresent()) {
            System.out.println("Circuito no encontrado");
            return null;
        } else {
            System.out.println("Circuito encontrado con éxito!");
            return op.get();
        }
    }

    @Override
    public void eliminarCircuito(Long id) {
        if (circuitoRepo.existsById(id)) {
            circuitoRepo.deleteById(id);
            System.out.println("Circuito con el id: " + id + " borrado.");
        }
        System.out.println("No se encontró el circuito con el id: " + id );
    }

}
