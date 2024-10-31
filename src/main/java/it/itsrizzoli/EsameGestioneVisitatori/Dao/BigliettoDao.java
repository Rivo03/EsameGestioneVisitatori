package it.itsrizzoli.EsameGestioneVisitatori.Dao;

import it.itsrizzoli.EsameGestioneVisitatori.Model.Biglietto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BigliettoDao extends CrudRepository<Biglietto, Long> {
}
