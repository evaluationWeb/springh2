package com.adrar.cdah2.controller;

import com.adrar.cdah2.dto.LivreDto;
import com.adrar.cdah2.exception.LivreNotFoundException;
import com.adrar.cdah2.exception.NoLivreFoundException;
import com.adrar.cdah2.model.Livre;
import com.adrar.cdah2.service.LivreService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LivreController {

    @Autowired
    private LivreService livreService;

    // Méthode qui retourne tous les objets Livre
    @GetMapping("/livres")
    public Iterable<Livre> getAllLivres() {
        return livreService.getAll();
    }

    @GetMapping("/livre/{id}")
    public Livre getLivreById(@PathVariable Integer id) {
        return livreService.getById(id).orElseThrow(
                () -> new LivreNotFoundException(id)
        );
    }

    // Méthode qui ajoute un Livre
    @PostMapping("/livre")
    @ResponseStatus(HttpStatus.CREATED)
    public Livre saveLivre(@Valid @RequestBody Livre livre) {
        return livreService.add(livre);
    }

    // Méthode qui supprime un Livre par son id
    @DeleteMapping("/livre/{id}")
    public String deleteLivreById(@PathVariable Integer id) {
        if (livreService.remove(id)) {
            return "Livre supprimé avec succes";
        }
        return "Livre introuvable";
    }

    // Méthode qui met à jour un Livre
    @PutMapping("/livre/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Livre updateLivreById(@PathVariable Integer id, @RequestBody Livre livre) {
        return livreService.update(livre, id);
    }

    //Méthode qui retourne un livredto
    @GetMapping("/livredto/{id}")
    @ResponseStatus(HttpStatus.OK)
    public LivreDto getLivreDtoById(@PathVariable Integer id) {
        return livreService.getLivreDtoById(id);
    }

    //Méthode qui retourne tous les objets LivreDto
    @GetMapping("/livresdto")
    @ResponseStatus(HttpStatus.OK)
    public List<LivreDto> getAllLivresDto() {
        return livreService.getAllLivreDto();
    }
}
