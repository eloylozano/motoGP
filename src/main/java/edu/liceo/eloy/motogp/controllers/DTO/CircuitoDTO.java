package edu.liceo.eloy.motogp.controllers.DTO;

import java.util.List;

import edu.liceo.eloy.motogp.models.Carrera;
import edu.liceo.eloy.motogp.models.enumerated.Conduccion;

public class CircuitoDTO {

    private String nombre;

    private String localidad;
    
    private List<Carrera> listaCarreras;






    public CircuitoDTO() {
    }

    public CircuitoDTO(String nombre, String localidad, List<Carrera> listaCarreras) {
        this.nombre = nombre;
        this.localidad = localidad;
        this.listaCarreras = listaCarreras;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public List<Carrera> getListaCarreras() {
        return listaCarreras;
    }

    public void setListaCarreras(List<Carrera> listaCarreras) {
        this.listaCarreras = listaCarreras;
    }

}
