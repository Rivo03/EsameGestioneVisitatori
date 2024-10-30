//UserController
package it.itsrizzoli.EsameGestioneVisitatori.Controller;

import it.itsrizzoli.EsameGestioneVisitatori.Dao.BigliettoDao;
import it.itsrizzoli.EsameGestioneVisitatori.Dao.InteresseDao;
import it.itsrizzoli.EsameGestioneVisitatori.Dao.OrarioAperturaDao;
import it.itsrizzoli.EsameGestioneVisitatori.Dao.VisitaGuidataDao;
import it.itsrizzoli.EsameGestioneVisitatori.Model.Biglietto;
import it.itsrizzoli.EsameGestioneVisitatori.Model.Interesse;
import it.itsrizzoli.EsameGestioneVisitatori.Model.OrarioApertura;
import it.itsrizzoli.EsameGestioneVisitatori.Model.VisitaGuidata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class VisitatoreController {

    @Autowired
    private BigliettoDao bigliettoDao;

    @Autowired
    private OrarioAperturaDao orarioAperturaDao;

    @Autowired
    private VisitaGuidataDao visitaGuidataDao;

    @Autowired
    private InteresseDao interesseDao;

    @PostMapping("/biglietti")
    public ResponseEntity<Biglietto> creaBiglietto(@RequestBody @Validated Biglietto biglietto) {
        if (biglietto.getDataVisita() == null || biglietto.getIdVisitatore() == null) {
            throw new IllegalArgumentException("ID del visitatore e data di visita non possono essere nulli");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(bigliettoDao.save(biglietto));
    }

    @GetMapping("/orari")
    public List<OrarioApertura> getOrariApertura() {
        return orarioAperturaDao.findAll();
    }

    @PostMapping("/visite-guidate")
    public ResponseEntity<VisitaGuidata> creaVisitaGuidata(@RequestBody @Validated VisitaGuidata visitaGuidata) {
        return ResponseEntity.status(HttpStatus.CREATED).body(visitaGuidataDao.save(visitaGuidata));
    }

    @PostMapping("/interessi")
    public ResponseEntity<Interesse> creaInteresse(@RequestBody @Validated Interesse interesse) {
        return ResponseEntity.status(HttpStatus.CREATED).body(interesseDao.save(interesse));
    }

    @GetMapping("/interessi")
    public List<Interesse> getInteressi() {
        return interesseDao.findAll();
    }

    @GetMapping("/visite-guidate/filtra")
    public List<VisitaGuidata> filtraVisiteGuidate(@RequestParam List<String> temi) {
        return visitaGuidataDao.findByTemaIn(temi);
    }
}
