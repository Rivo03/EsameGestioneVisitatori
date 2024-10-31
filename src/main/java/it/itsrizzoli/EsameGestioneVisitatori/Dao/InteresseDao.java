package it.itsrizzoli.EsameGestioneVisitatori.Dao;

import it.itsrizzoli.EsameGestioneVisitatori.Model.Interesse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InteresseDao extends JpaRepository<Interesse, Long> {
    // Non c'è bisogno di ridefinire findAll(), è già incluso in JpaRepository
}
