package com.adrar.cdah2.service;

import com.adrar.cdah2.dto.LivreDto;
import com.adrar.cdah2.model.Livre;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class LivreDtoWrapper {

    public LivreDto livreToDto(Livre livre) {
        return new LivreDto(
                livre.getId(),
                livre.getTitre(),
                livre.getAuteur(),
                livre.getDatePublication().toString(),
                livre.getMaisonEdition().getLibele(),
                livre.getUser().getEmail()
        );
    }
}
