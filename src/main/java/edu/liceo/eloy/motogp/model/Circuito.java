package edu.liceo.eloy.motogp.model;

import org.hibernate.annotations.GeneratorType;

import jakarta.persistence.*;

@Entity
@Table(name = "circuitos")
public class Circuito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nombre", length = 55, unique = false, nullable = false)
    private String nombre;

    @Column(name = "localidad", length = 55, unique = false, nullable = false)
    private String localdidad;

    public Circuito() {
    }

    public Circuito(String nombre, String localdidad) {
        this.nombre = nombre;
        this.localdidad = localdidad;
    }

    public Circuito(long id, String nombre, String localdidad) {
        this.id = id;
        this.nombre = nombre;
        this.localdidad = localdidad;
    }

    @Override
    public String toString() {
        return "Circuito [id=" + id + ", nombre=" + nombre + ", localdidad=" + localdidad + "]";
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLocaldidad() {
        return localdidad;
    }

    public void setLocaldidad(String localdidad) {
        this.localdidad = localdidad;
    }

}
