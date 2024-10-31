package it.itsrizzoli.EsameGestioneVisitatori.Dao;

import it.itsrizzoli.EsameGestioneVisitatori.Model.VisitaGuidata;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface VisitaGuidataDao extends CrudRepository<VisitaGuidata, Long> {
    List<VisitaGuidata> findByTemaIn(List<String> temi);
}
