package com.adrar.cdah2.dto;

import java.util.List;

public record LivreDto(
        Integer id,
        String titre,
        String auteur,
        String datePublication,
        String maisonEdition,
        String email,
        List<String> genres
) {
}
