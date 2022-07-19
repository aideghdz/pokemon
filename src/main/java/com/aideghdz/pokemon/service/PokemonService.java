package com.aideghdz.pokemon.service;

import com.aideghdz.pokemon.model.PokemonBase;
import com.aideghdz.pokemon.model.PokemonResponse;
import com.aideghdz.pokemon.util.CustomPage;
import skaro.pokeapi.query.PageQuery;

public interface PokemonService {

    CustomPage<PokemonBase> findAllPage(PageQuery pageable);

    PokemonResponse findPokemonDetailInfo(String name);
}