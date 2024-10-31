package it.itsrizzoli.EsameGestioneVisitatori.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

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
    private String data;

    // Getters e Setters
    // (Stesso codice del modello che hai fornito in precedenza)
}
