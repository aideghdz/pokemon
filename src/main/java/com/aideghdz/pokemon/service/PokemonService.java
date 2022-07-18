package com.aideghdz.pokemon.service;

import com.aideghdz.pokemon.model.PokemonBase;
import com.aideghdz.pokemon.util.CustomPage;
import skaro.pokeapi.query.PageQuery;
import skaro.pokeapi.resource.NamedApiResourceList;
import skaro.pokeapi.resource.pokemon.Pokemon;

public interface PokemonService {
    CustomPage<PokemonBase> findAllPage(PageQuery pageable);


}