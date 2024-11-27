package edu.liceo.eloy.motogp.models;

import jakarta.persistence.*;

@Entity
@Table(name = "carreras")
public class Carrera {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_piloto", nullable = false)
    private Piloto piloto;

    @ManyToOne
    @JoinColumn(name = "id_circuito", nullable = false)
    private Circuito circuito;

    @Column(name = "temporada", nullable = false)
    private String temporada;

    @Column(name = "posicion")
    private Integer posicion;

    public Carrera(Long id, Piloto piloto, Circuito circuito, String temporada, Integer posicion) {
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

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(Integer posicion) {
        this.posicion = posicion;
    }

    public String getTemporada() {
        return temporada;
    }

    public void setTemporada(String temporada) {
        this.temporada = temporada;
    }


    @Override
    public String toString() {
        return "Carrera [id=" + id + ", piloto=" + piloto + ", circuito=" + circuito + ", temporada=" + temporada
                + ", posicion=" + posicion + "]";

    }

}
