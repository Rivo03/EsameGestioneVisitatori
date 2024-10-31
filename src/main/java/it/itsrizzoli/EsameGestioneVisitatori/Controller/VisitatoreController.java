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
import org.springframework.ui.Model;
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
        return "index";  // restituisce index.html
    }

    @GetMapping("/biglietti")
    public String biglietti() {
        return "biglietti";  // restituisce biglietti.html
    }

    @GetMapping("/visite-guidate")
    public String visiteGuidate() {
        return "visite-guidate";  // restituisce visite-guidate.html
    }

    @GetMapping("/interessi")
    public String mostraInteressi(Model model) {
        List<Interesse> interessi = interesseDao.findAll();
        model.addAttribute("interessi", interessi);
        return "interessi";  // restituisce interessi.html
    }

    @PostMapping
    public ResponseEntity<Biglietto> creaBiglietto(@RequestBody Biglietto biglietto) {
        // Logica di calcolo del prezzo e salvataggio
        double prezzoBase = 10.0; // Prezzo base
        if (biglietto.isConGuida()) {
            prezzoBase += 5.0; // Costo extra per la guida
        }
        if (biglietto.getEta() < 18) {
            prezzoBase *= 0.5; // Sconto per i minorenni
        }
        biglietto.setPrezzo(prezzoBase);
        bigliettoDao.save(biglietto);
        return ResponseEntity.ok(biglietto);
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
    public ResponseEntity<String> creaPercorso(@RequestParam List<Long> interesseIds) {
        if (interesseIds.size() > 3) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Seleziona fino a tre interessi.");
        }

        // Logica per creare un percorso personalizzato basato sugli interessi selezionati
        StringBuilder percorso = new StringBuilder("Percorso creato con gli interessi: ");
        for (Long interesseId : interesseIds) {
            percorso.append(interesseId).append(" ");  // Aggiungi l'id dell'interesse al percorso
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(percorso.toString());
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
