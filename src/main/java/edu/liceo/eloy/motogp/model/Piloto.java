package edu.liceo.eloy.motogp.model;

import java.util.List;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import edu.liceo.eloy.motogp.model.enumerated.Conduccion;
import jakarta.persistence.*;

@Entity
@Table(name = "pilotos")
public class Piloto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nombre", length = 55, nullable = false)
    private String nombre;

    @Enumerated(EnumType.STRING)
    @Column(name = "conduccion", nullable = false)
    private Conduccion conduccion;

    @OnDelete(action = OnDeleteAction.CASCADE)
    @OneToMany(mappedBy = "piloto", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Carrera> carreras;

    public Piloto() {
    }

    public Piloto(String nombre, Conduccion conduccion) {
        this.nombre = nombre;
        this.conduccion = conduccion;
    }

    public Piloto(long id, String nombre, Conduccion conduccion) {
        this.id = id;
        this.nombre = nombre;
        this.conduccion = conduccion;
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

    public Conduccion getConduccion() {
        return conduccion;
    }

    public void setConduccion(Conduccion conduccion) {
        this.conduccion = conduccion;
    }

    @Override
    public String toString() {
        return "Piloto [id=" + id + ", nombre=" + nombre + ", conduccion=" + conduccion + "]";
    }

}
