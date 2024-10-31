package it.itsrizzoli.EsameGestioneVisitatori.Dao;

import it.itsrizzoli.EsameGestioneVisitatori.Model.Interesse;
import it.itsrizzoli.EsameGestioneVisitatori.Model.OrarioApertura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface InteresseDao extends CrudRepository<Interesse, Long> {
    List<Interesse> findAll();
}
