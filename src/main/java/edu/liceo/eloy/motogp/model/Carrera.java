package edu.liceo.eloy.motogp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
@Table(name = "pilotos_carreras")
public class Carrera {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "id_piloto")
    @JsonIgnore
    private Piloto piloto;

    @JoinColumn(name = "id_circuito")
    @JsonIgnore
    private Circuito circuito;

    @Column(name = "temporada", length = 4, unique = false, nullable = false)
    private int temporada;

    @Column(name = "posicion", length = 2, unique = false, nullable = true)
    private int posicion;

    public Carrera(Long id, Piloto piloto, Circuito circuito, int temporada, int posicion) {
        this.id = id;
        this.piloto = piloto;
        this.circuito = circuito;
        this.temporada = temporada;
        this.posicion = posicion;
    }

    public Carrera() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public int getTemporada() {
        return temporada;
    }

    public void setTemporada(int temporada) {
        this.temporada = temporada;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    @Override
    public String toString() {
        return "Carrera [id=" + id + ", piloto=" + piloto + ", circuito=" + circuito + ", temporada=" + temporada
                + ", posicion=" + posicion + "]";
    }

}
