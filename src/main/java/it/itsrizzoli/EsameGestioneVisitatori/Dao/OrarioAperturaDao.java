package it.itsrizzoli.EsameGestioneVisitatori.Dao;


import it.itsrizzoli.EsameGestioneVisitatori.Model.OrarioApertura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrarioAperturaDao extends CrudRepository<OrarioApertura, Long> {

    List<OrarioApertura> findAll();
}
