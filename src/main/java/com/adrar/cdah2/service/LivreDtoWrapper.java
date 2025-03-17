package com.adrar.cdah2.service;

import com.adrar.cdah2.dto.LivreDto;
import com.adrar.cdah2.model.Genre;
import com.adrar.cdah2.model.Livre;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class LivreDtoWrapper {

    public LivreDto livreToDto(Livre livre) {
        //Création d'une liste vide
        List<String> genres = new ArrayList<>();
        //Ajouter des libele de genre à la liste
        for(Genre genre : livre.getGenres()) {
            genres.add(genre.getName());
        }
        return new LivreDto(
                livre.getId(),
                livre.getTitre(),
                livre.getAuteur(),
                livre.getDatePublication().toString(),
                livre.getMaisonEdition().getLibele(),
                livre.getUser().getEmail(),
                genres
        );
    }
}
