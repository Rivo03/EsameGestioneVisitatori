package it.itsrizzoli.EsameGestioneVisitatori.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "interesse") // Nome della tabella
public class Interesse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
