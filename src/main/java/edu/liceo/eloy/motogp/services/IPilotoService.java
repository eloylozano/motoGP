package edu.liceo.eloy.motogp.services;

import java.util.List;
import java.util.Set;

import edu.liceo.eloy.motogp.controllers.DTO.PilotoDTO;
import edu.liceo.eloy.motogp.models.Piloto;
import edu.liceo.eloy.motogp.models.enumerated.Conduccion;

public interface IPilotoService {

    public List<PilotoDTO> getListaPilotos();

    public PilotoDTO guardarPiloto(PilotoDTO pilotoDTO);

    public PilotoDTO getPilotoId(Long id);

    public Piloto actualizarPiloto(Piloto piloto);

    public void borrarPiloto(Long id);

    public Set<Piloto> pilotosConPodium();

    public Piloto mayorVictorias();

    public List<PilotoDTO> getPilotoByEstilo(Conduccion conduccion);
}
