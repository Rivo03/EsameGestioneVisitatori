package it.itsrizzoli.EsameGestioneVisitatori.Controller;

import it.itsrizzoli.EsameGestioneVisitatori.Dao.BigliettoDao;
import it.itsrizzoli.EsameGestioneVisitatori.Model.Biglietto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class BigliettoController {

    private final BigliettoDao bigliettodao;

    public BigliettoController(BigliettoDao bigliettodao) {
        this.bigliettodao = bigliettodao;
    }

    @PostMapping("/biglietti")
    public ResponseEntity<Biglietto> creaBiglietto(@RequestBody Biglietto biglietto) {
        // Calcola il prezzo
        double prezzoBase = 10.0; // prezzo base
        if (biglietto.isConGuida()) {
            prezzoBase += 5.0; // costo extra per la guida
        }
        if (biglietto.getEta() < 18) {
            prezzoBase *= 0.5; // sconto per i minorenni
        }
        biglietto.setPrezzo(prezzoBase);

        // Salva il biglietto nel database
        bigliettodao.save(biglietto);
        return ResponseEntity.ok(biglietto);
    }
}
