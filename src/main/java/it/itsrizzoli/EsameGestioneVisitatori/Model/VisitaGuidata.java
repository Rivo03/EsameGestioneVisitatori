package it.itsrizzoli.EsameGestioneVisitatori.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * Rappresenta una visita guidata con i dettagli relativi al tema, alla guida e alla data.
 */
@Entity
public class VisitaGuidata {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Long idGuida;

    @NotNull
    @Size(min = 1, message = "Il tema non può essere vuoto")
    private String tema;

    @NotNull
    private String data;  // Aggiunto per gestire la data della visita

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdGuida() {
        return idGuida;
    }

    public void setIdGuida(Long idGuida) {
        this.idGuida = idGuida;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "VisitaGuidata{" +
                "id=" + id +
                ", idGuida=" + idGuida +
                ", tema='" + tema + '\'' +
                ", data='" + data + '\'' +  // Aggiunto al toString
                '}';
    }
}
