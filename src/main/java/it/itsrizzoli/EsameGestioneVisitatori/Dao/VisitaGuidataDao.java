package it.itsrizzoli.EsameGestioneVisitatori.Dao;

import it.itsrizzoli.EsameGestioneVisitatori.Model.VisitaGuidata;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VisitaGuidataDao extends JpaRepository<VisitaGuidata, Long> {
    List<VisitaGuidata> findByTemaIn(List<String> temi);
}
