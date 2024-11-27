package edu.liceo.eloy.motogp.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.liceo.eloy.motogp.controllers.DTO.PilotoDTO;
import edu.liceo.eloy.motogp.models.Carrera;
import edu.liceo.eloy.motogp.models.Circuito;
import edu.liceo.eloy.motogp.models.Piloto;
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
    public PilotoDTO guardarPiloto(PilotoDTO pilotoDTO) {
        Piloto piloto = new Piloto();
        piloto.setNombre(pilotoDTO.getNombre());
        piloto.setConduccion(pilotoDTO.getConduccion());
        piloto.setCarreras(pilotoDTO.getListaCarreras()); // Si es necesario mapear las carreras también

        // Guardar el Piloto en la base de datos
        Piloto pilotoGuardado = pilotosRepo.save(piloto);

        // Convertir el Piloto guardado de vuelta a PilotoDTO para devolverlo
        PilotoDTO pilotoDTORespuesta = new PilotoDTO();
        pilotoDTORespuesta.setNombre(pilotoGuardado.getNombre());
        pilotoDTORespuesta.setConduccion(pilotoGuardado.getConduccion());
        pilotoDTORespuesta.setListaCarreras(pilotoGuardado.getCarreras());

        return pilotoDTORespuesta;
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

    @Override
    public Piloto mayorVictorias() {
        List<Carrera> carreras = carrerasRepo.findByPosicion(1);
        List<Piloto> pilotosUnicos = new ArrayList<>();
        List<Integer> conteos = new ArrayList<>();
        Piloto pilotoLaureado = null;
        int maxVictorias = 0;

        // Recorrer las carreras
        for (Carrera carrera : carreras) {
            Piloto piloto = carrera.getPiloto();

            // Buscar si el piloto ya está en la lista de únicos
            int index = pilotosUnicos.indexOf(piloto);
            if (index != -1) {
                // Si está, incrementar su conteo
                conteos.set(index, conteos.get(index) + 1);
            } else {
                // Si no está, añadirlo como único y empezar su conteo
                pilotosUnicos.add(piloto);
                conteos.add(1);
            }
        }

        // Determinar el piloto con más victorias
        for (int i = 0; i < conteos.size(); i++) {
            if (conteos.get(i) > maxVictorias) {
                maxVictorias = conteos.get(i);
                pilotoLaureado = pilotosUnicos.get(i);
            }
        }

        return pilotoLaureado;
    }

}
