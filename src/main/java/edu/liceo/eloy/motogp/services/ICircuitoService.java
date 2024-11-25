package edu.liceo.eloy.motogp.services;

import java.util.List;

import edu.liceo.eloy.motogp.model.Circuito;

public interface ICircuitoService {

    public List<Circuito> getCircuito();

    public Circuito guardarCircuito(Circuito circuito);

    public Circuito actualizarCircuito(Circuito circuito);

    public Circuito buscarcirCircuito(long id);

    public Circuito borrarCircuito(long id);

}
