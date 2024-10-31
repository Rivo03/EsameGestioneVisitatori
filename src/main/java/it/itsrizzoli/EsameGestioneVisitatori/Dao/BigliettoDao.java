package it.itsrizzoli.EsameGestioneVisitatori.Dao;

import  it.itsrizzoli.EsameGestioneVisitatori.Model.Biglietto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BigliettoDao extends CrudRepository<Biglietto, Long> {
    List<Biglietto> findAll();
}
