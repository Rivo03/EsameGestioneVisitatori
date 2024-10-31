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
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/")
public class VisitatoreController {

    @Autowired
    private BigliettoDao bigliettoDao;

    @Autowired
    private OrarioAperturaDao orarioAperturaDao;

    @Autowired
    private VisitaGuidataDao visitaGuidataDao;

    @Autowired
    private InteresseDao interesseDao;

    @GetMapping("")
    public String index() {
        return "index";
    }

    @GetMapping("/biglietti")
    public String biglietti() {
        return "biglietti";
    }

    @GetMapping("/visite-guidate")
    public String visiteGuidate() {
        return "visite-guidate";
    }

    @GetMapping("/interessi")
    public String interessi() {
        return "interessi";
    }

    @PostMapping("/api/biglietti")
    public ResponseEntity<String> creaBiglietto(@RequestBody @Validated Biglietto biglietto) {
        if (biglietto.getDataVisita() == null || biglietto.getIdVisitatore() == null) {
            throw new IllegalArgumentException("ID del visitatore e data di visita non possono essere nulli");
        }
        bigliettoDao.save(biglietto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Biglietto creato: " + biglietto);
    }

    @GetMapping("/orari")
    public List<OrarioApertura> getOrariApertura() {
        return orarioAperturaDao.findAll();
    }

    @PostMapping("/api/visite-guidate")
    public ResponseEntity<String> creaVisitaGuidata(@RequestBody @Validated VisitaGuidata visitaGuidata) {
        visitaGuidataDao.save(visitaGuidata);
        return ResponseEntity.status(HttpStatus.CREATED).body("Visita guidata creata: " + visitaGuidata);
    }

    @PostMapping("/api/interessi")
    public ResponseEntity<String> creaInteresse(@RequestBody @Validated Interesse interesse) {
        interesseDao.save(interesse);
        return ResponseEntity.status(HttpStatus.CREATED).body("Interesse creato: " + interesse);
    }

    @GetMapping("/api/interessi")
    public List<Interesse> getInteressi() {
        return interesseDao.findAll();
    }

    @GetMapping("/api/visite-guidate/filtra")
    public List<VisitaGuidata> filtraVisiteGuidate(@RequestParam List<String> temi) {
        return visitaGuidataDao.findByTemaIn(temi);
    }
}