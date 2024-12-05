package edu.liceo.eloy.motogp.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.liceo.eloy.motogp.controllers.DTO.PilotoDTO;
import edu.liceo.eloy.motogp.models.*;
import edu.liceo.eloy.motogp.models.enumerated.Conduccion;
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
    public List<PilotoDTO> getListaPilotos() {
        List<Piloto> pilotos = pilotosRepo.findAll();
        List<PilotoDTO> pilotosDTO = new ArrayList<>();

        for (Piloto piloto : pilotos) {
            PilotoDTO pilotoDTO = new PilotoDTO();

            pilotoDTO.setNombre(piloto.getNombre());
            pilotoDTO.setConduccion(piloto.getConduccion());
            pilotoDTO.setListaCarreras(piloto.getCarreras());

            pilotosDTO.add(pilotoDTO);
        }
        return pilotosDTO;
    }

    @Override
    public PilotoDTO guardarPiloto(Piloto pi) {
        Piloto pilotoBD = pilotosRepo.save(pi);
        PilotoDTO pilotoDTO = new PilotoDTO();

        pilotoDTO.setNombre(pilotoBD.getNombre());
        pilotoDTO.setConduccion(pilotoBD.getConduccion());
        pilotoDTO.setListaCarreras(pilotoBD.getCarreras());
        return pilotoDTO;
    }
    

    @Override
    public PilotoDTO getPilotoId(Long id) {
        Optional<Piloto> op = pilotosRepo.findById(id);
        if (op.isPresent()) {
            PilotoDTO pilotoDTO = new PilotoDTO();
            Piloto piloto = op.get();

            pilotoDTO.setNombre(piloto.getNombre());
            pilotoDTO.setConduccion(piloto.getConduccion());
            pilotoDTO.setListaCarreras(piloto.getCarreras());

            return pilotoDTO;
        } else {
            System.out.println("No se ha encontrado el piloto con ID: " + id);
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

    @Override
    public List<PilotoDTO> getPilotoByEstilo(Conduccion conduccion) {
        List<Piloto> pilotos = pilotosRepo.findByConduccion(conduccion);

        if (pilotos.isEmpty()) {
            System.out.println("No se han encontrado pilotos con ese estilo de conducción.");
            return null; 
        }

        // Crear lista para almacenar los DTOs
        List<PilotoDTO> pilotosDTO = new ArrayList<>();

        // Convertir cada Piloto a PilotoDTO usando un bucle
        for (Piloto piloto : pilotos) {
            PilotoDTO pilotoDTO = new PilotoDTO(
                    piloto.getNombre(),
                    piloto.getConduccion(),
                    piloto.getCarreras());
            pilotosDTO.add(pilotoDTO);
        }

        return pilotosDTO;
    }

}
