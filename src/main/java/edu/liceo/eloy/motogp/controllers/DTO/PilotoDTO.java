package edu.liceo.eloy.motogp.controllers.DTO;

import java.util.List;

import edu.liceo.eloy.motogp.models.Carrera;
import edu.liceo.eloy.motogp.models.enumerated.Conduccion;

public class PilotoDTO {

    private String nombre;

    private Conduccion conduccion;
    
    private List<Carrera> listaCarreras;




    public PilotoDTO() {
    }

    public PilotoDTO(String nombre, Conduccion conduccion, List<Carrera> listaCarreras) {
        this.nombre = nombre;
        this.conduccion = conduccion;
        this.listaCarreras = listaCarreras;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Conduccion getConduccion() {
        return conduccion;
    }

    public void setConduccion(Conduccion conduccion) {
        this.conduccion = conduccion;
    }

    public List<Carrera> getListaCarreras() {
        return listaCarreras;
    }

    public void setListaCarreras(List<Carrera> listaCarreras) {
        this.listaCarreras = listaCarreras;
    }


    

}
