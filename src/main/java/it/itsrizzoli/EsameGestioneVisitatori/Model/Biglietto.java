package it.itsrizzoli.EsameGestioneVisitatori.Model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Biglietto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long idVisitatore;
    private LocalDate dataVisita;
    private boolean conGuida;
    private int eta;
    private double prezzo;

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdVisitatore() {
        return idVisitatore;
    }

    public void setIdVisitatore(Long idVisitatore) {
        this.idVisitatore = idVisitatore;
    }

    public LocalDate getDataVisita() {
        return dataVisita;
    }

    public void setDataVisita(LocalDate dataVisita) {
        this.dataVisita = dataVisita;
    }

    public boolean isConGuida() {
        return conGuida;
    }

    public void setConGuida(boolean conGuida) {
        this.conGuida = conGuida;
    }

    public int getEta() {
        return eta;
    }

    public void setEta(int eta) {
        this.eta = eta;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }
}
