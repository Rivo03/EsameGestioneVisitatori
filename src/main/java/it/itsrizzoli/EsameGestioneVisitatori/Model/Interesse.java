package it.itsrizzoli.EsameGestioneVisitatori.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "interesse")
public class Interesse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false, length = 100)
    private String nome;


    public Interesse() {
    }


    public Interesse(String nome) {
        this.nome = nome;
    }

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

    @Override
    public String toString() {
        return "Interesse{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
