package it.itsrizzoli.EsameGestioneVisitatori.Dao;

import  it.itsrizzoli.EsameGestioneVisitatori.Model.Biglietto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BigliettoDao extends CrudRepository<Biglietto, String> {
    List<Biglietto> findAll();
}
