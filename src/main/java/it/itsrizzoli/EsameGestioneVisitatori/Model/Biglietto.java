package it.itsrizzoli.EsameGestioneVisitatori.Model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "biglietto") // Aggiungi il nome della tabella se necessario
public class Biglietto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_visitatore") // Nome della colonna nel database
    private Long idVisitatore;

    @Column(name = "data_visita") // Nome della colonna nel database
    private String dataVisita;

    @ManyToMany
    @JoinTable(
            name = "biglietto_interesse", // Nome della tabella di join
            joinColumns = @JoinColumn(name = "biglietto_id"),
            inverseJoinColumns = @JoinColumn(name = "interesse_id"))
    private List<Interesse> interessi;

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

    public String getDataVisita() {
        return dataVisita;
    }

    public void setDataVisita(String dataVisita) {
        this.dataVisita = dataVisita;
    }

    public List<Interesse> getInteressi() {
        return interessi;
    }

    public void setInteressi(List<Interesse> interessi) {
        this.interessi = interessi;
    }
}
