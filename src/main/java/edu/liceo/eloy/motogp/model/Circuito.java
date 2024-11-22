package edu.liceo.eloy.motogp.model;

import java.util.List;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
@Table(name = "circuitos")
public class Circuito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nombre", length = 55, nullable = false)
    private String nombre;

    @Column(name = "localidad", length = 55, nullable = false)
    private String localidad;

    @OnDelete(action = OnDeleteAction.CASCADE)
    @OneToMany(mappedBy = "circuito", orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Carrera> carreras;

    public Circuito() {
    }

    public Circuito(String nombre, String localidad) {
        this.nombre = nombre;
        this.localidad = localidad;
    }

    public Circuito(long id, String nombre, String localidad) {
        this.id = id;
        this.nombre = nombre;
        this.localidad = localidad;
    }

    @Override
    public String toString() {
        return "Circuito [id=" + id + ", nombre=" + nombre + ", localidad=" + localidad + "]";
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

    public String getlocalidad() {
        return localidad;
    }

    public void setlocalidad(String localidad) {
        this.localidad = localidad;
    }

}
