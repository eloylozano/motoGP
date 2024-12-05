package edu.liceo.eloy.motogp.services;

import java.util.List;

import edu.liceo.eloy.motogp.models.Carrera;

public interface ICarreraService {

    public List<Carrera> getCarreras();
    
    public Carrera guardarCarrera(Carrera carrera);

    public Carrera actualizarCarrera(Carrera carrera);

    public Carrera buscarCarrera(Long id);

    public void borrarCarreras(Long id);

    public List<Carrera> verPodiums();
}
