package edu.liceo.eloy.motogp.services;

import java.util.List;

import edu.liceo.eloy.motogp.model.Piloto;

public interface IPilotoService {

    public List<Piloto> getPiloto();

    public Piloto guardarPiloto(Piloto piloto);

    public Piloto buscarPiloto(long id);

    public Piloto actualiazrPiloto(Piloto piloto);

    public Piloto borrarPiloto(long id);

}
