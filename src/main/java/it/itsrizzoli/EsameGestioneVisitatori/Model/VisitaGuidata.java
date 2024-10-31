package it.itsrizzoli.EsameGestioneVisitatori.Model;

import jakarta.persistence.*;

@Entity
public class VisitaGuidata {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long idGuida;
    private String tema;

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
}
