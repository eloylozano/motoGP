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

            // Actualizar las propiedades del circuito
            circuitoActualizado.setNombre(circuito.getNombre());
            circuitoActualizado.setLocalidad(circuito.getLocalidad());

            // Si las carreras también se deben actualizar, manejar eso
            for (Carrera carrera : circuito.getCarreras()) {
                carrera.setCircuito(circuitoActualizado); // Asegurarse de que cada carrera esté asociada al circuito
                                                          // actualizado
            }

            return circuitoRepo.save(circuitoActualizado);
        } else {
            return circuitoRepo.save(circuito); // Si no existe, guardar como nuevo
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
    public Circuito eliminarCircuito(Long id) {
        Optional<Circuito> op = circuitoRepo.findById(id);
        if (!op.isPresent()) {
            System.out.println("Circuito no encontrado. No se pudo borrar!");
            return null;
        } else {
            System.out.println("Se ha borrado el circuito con el id: " + id);
            circuitoRepo.deleteById(id);
            return op.get();
        }
    }

}
