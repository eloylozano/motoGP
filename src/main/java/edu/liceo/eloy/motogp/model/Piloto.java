package edu.liceo.eloy.motogp.model;

import edu.liceo.eloy.motogp.model.enumerated.Conduccion;
import jakarta.persistence.*;

@Entity
@Table(name = "pilotos")
public class Piloto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nombre", length = 55, unique = false, nullable = false)
    private String nombre;

    @Column(name = "conduccion", columnDefinition = "ENUM('AGRESIVA', 'PASIVA', 'TEMERARIA')", unique = false, nullable = false)
    private Conduccion conduccion;

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
