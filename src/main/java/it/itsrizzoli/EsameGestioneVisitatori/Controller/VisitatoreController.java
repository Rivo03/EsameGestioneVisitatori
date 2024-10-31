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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.List;

@Controller
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

    @GetMapping("")
    public ModelAndView index() {
        return new ModelAndView("index");  // restituisce index.html
    }

    @GetMapping("/biglietti")
    public ModelAndView biglietti() {
        ModelAndView modelAndView = new ModelAndView("biglietti");  // restituisce biglietti.html
        List<Biglietto> biglietti = bigliettoDao.findAll();
        modelAndView.addObject("biglietti", biglietti);
        return modelAndView;
    }

    @GetMapping("/visite-guidate")
    public ModelAndView visiteGuidate() {
        ModelAndView modelAndView = new ModelAndView("visite-guidate");  // restituisce visite-guidate.html
        Iterable<VisitaGuidata> visite = visitaGuidataDao.findAll();
        modelAndView.addObject("visite", visite);
        return modelAndView;
    }

    @GetMapping("/interessi")
    public ModelAndView interessi() {
        ModelAndView modelAndView = new ModelAndView("interessi");  // restituisce interessi.html
        List<Interesse> interessi = interesseDao.findAll();
        modelAndView.addObject("interessi", interessi);
        return modelAndView;  // Restituisce la vista con gli interessi
    }

    @PostMapping("/interessi")
    public ModelAndView creaInteresse(@RequestParam("nome") String nome) {
        Interesse interesse = new Interesse();
        interesse.setNome(nome);

        interesseDao.save(interesse);

        ModelAndView modelAndView = new ModelAndView("interessi");  // Supponendo che tu abbia una vista 'interessi.html'
        modelAndView.addObject("message", "Interesse creato: " + interesse.getNome());
        modelAndView.addObject("interessi", interesseDao.findAll()); // Recupera la lista aggiornata degli interessi
        return modelAndView;
    }

    @GetMapping("/orari")
    public List<OrarioApertura> getOrariApertura() {
        return orarioAperturaDao.findAll();
    }

    @PostMapping("/visite-guidate")
    public ResponseEntity<String> creaVisitaGuidata(
            @RequestParam("tema") String tema,
            @RequestParam("data") String data,
            @RequestParam("idGuida") Long idGuida) {  // Aggiunto per gestire l'id della guida

        VisitaGuidata visitaGuidata = new VisitaGuidata();
        visitaGuidata.setTema(tema);
        visitaGuidata.setData(data);  // Imposta la data
        visitaGuidata.setIdGuida(idGuida);  // Imposta l'id della guida

        visitaGuidataDao.save(visitaGuidata);
        return ResponseEntity.status(HttpStatus.CREATED).body("Visita guidata creata: " + visitaGuidata);
    }


    @GetMapping("/visite-guidate/filtra")
    public List<VisitaGuidata> filtraVisiteGuidate(@RequestParam List<String> temi) {
        return visitaGuidataDao.findByTemaIn(temi);
    }
}
