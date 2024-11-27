package edu.liceo.eloy.motogp.controllers.DTO;

import java.util.List;

import edu.liceo.eloy.motogp.models.Circuito;
import edu.liceo.eloy.motogp.models.Piloto;
import edu.liceo.eloy.motogp.models.Carrera;

public class CarreraDTO {

    private Piloto piloto;

    private Circuito circuito;

    private List<Carrera> listaCarreras;

    public CarreraDTO(Piloto piloto, Circuito circuito, List<Carrera> listaCarreras) {
        this.piloto = piloto;
        this.circuito = circuito;
        this.listaCarreras = listaCarreras;
    }

    public CarreraDTO() {
    }

    public Piloto getPiloto() {
        return piloto;
    }

    public void setPiloto(Piloto piloto) {
        this.piloto = piloto;
    }

    public Circuito getCircuito() {
        return circuito;
    }

    public void setCircuito(Circuito circuito) {
        this.circuito = circuito;
    }

    public List<Carrera> getListaCarreras() {
        return listaCarreras;
    }

    public void setListaCarreras(List<Carrera> listaCarreras) {
        this.listaCarreras = listaCarreras;
    }

}
