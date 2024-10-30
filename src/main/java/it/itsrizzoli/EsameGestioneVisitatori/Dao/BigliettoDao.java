package it.itsrizzoli.EsameGestioneVisitatori.Dao;

import  it.itsrizzoli.EsameGestioneVisitatori.Model.Biglietto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BigliettoDao extends JpaRepository<Biglietto, Long> {
}
