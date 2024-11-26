package edu.liceo.eloy.motogp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.liceo.eloy.motogp.model.Carrera;
import edu.liceo.eloy.motogp.repositories.ICarreraRepository;
import jakarta.transaction.Transactional;

@Service
public class CarreraService implements ICarreraService {

    @Autowired
    ICarreraRepository carrerasRepo;

    @Override
    public List<Carrera> getCarreras() {
        return carrerasRepo.findAll();
    }

    @Override
    public Carrera guardarCarrera(Carrera carrera) {
        System.out.println("Carrera guardada!");
        return carrerasRepo.save(carrera);
    }

    @Override
    public Carrera actualizarCarrera(Carrera carrera) {
        Optional<Carrera> carreraExistente = carrerasRepo.findById(carrera.getId());
        if (carreraExistente.isPresent()) {
            Carrera carreraActualizada = carreraExistente.get();
            carreraActualizada.setPiloto(carrera.getPiloto());
            carreraActualizada.setCircuito(carrera.getCircuito());
            carreraActualizada.setTemporada(carrera.getTemporada());
            carreraActualizada.setPosicion(carrera.getPosicion());

            return carrerasRepo.save(carreraActualizada);
        } else {
            return carrerasRepo.save(carrera);
        }

    }

    @Override
    public Carrera buscarCarrera(Long id) {
        Optional<Carrera> op = carrerasRepo.findById(id);
        if (op.isPresent()) {
            System.out.println("Carrera encontrada con éxito!");
            return op.get();
        } else {
            System.out.println("La carrera con id: " + id + " no existe.");
            return null;
        }

    }

    @Transactional
    @Override
    public void borrarCarreras(Long id) {
        if (carrerasRepo.existsById(id)) {
            carrerasRepo.deleteById(id);
            System.out.println("La carrera se borró con éxisto!");
        } else {
            System.out.println("No se pudo borrar la carrera con el id: " + id);
        }
    }

    

}
