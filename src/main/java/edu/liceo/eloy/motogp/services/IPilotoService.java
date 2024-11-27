package edu.liceo.eloy.motogp.services;

import java.util.List;
import java.util.Set;

import edu.liceo.eloy.motogp.controllers.DTO.PilotoDTO;
import edu.liceo.eloy.motogp.models.Piloto;

public interface IPilotoService {

    public List<Piloto> getPiloto();

    public PilotoDTO guardarPiloto(PilotoDTO pilotoDTO);

    public Piloto buscarPiloto(Long id);

    public Piloto actualizarPiloto(Piloto piloto);

    public void borrarPiloto(Long id);

    public Set<Piloto> pilotosConPodium();

    public Piloto mayorVictorias();


}
