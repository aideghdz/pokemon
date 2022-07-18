package com.aideghdz.pokemon.service;

import com.aideghdz.pokemon.model.Pokemon;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import skaro.pokeapi.client.ReactiveCachingPokeApiClient;

@Slf4j
@Service
public class PokemonServiceImpl implements PokemonService{





    private ReactiveCachingPokeApiClient pokeApiClient;



    @Override
    public Page<Pokemon> findAllPage(Pageable pageable) {
        return null;
    }
}
