package com.aideghdz.pokemon.service;

import com.aideghdz.pokemon.model.Pokemon;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PokemonService {
    Page<Pokemon> findAllPage(Pageable pageable);
}