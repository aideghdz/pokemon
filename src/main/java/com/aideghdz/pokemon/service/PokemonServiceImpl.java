package com.aideghdz.pokemon.service;

import com.aideghdz.pokemon.mapper.PokemonBaseMapper;
import com.aideghdz.pokemon.model.PokemonBase;
import com.aideghdz.pokemon.util.CustomPage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import skaro.pokeapi.client.PokeApiClient;
import skaro.pokeapi.query.PageQuery;
import skaro.pokeapi.resource.NamedApiResource;
import skaro.pokeapi.resource.NamedApiResourceList;
import skaro.pokeapi.resource.pokemon.Pokemon;

import java.util.LinkedList;
import java.util.List;

@Slf4j
@Service
public class PokemonServiceImpl implements PokemonService{




    @Autowired
    private PokeApiClient pokeApiClient;

    @Autowired
    private PokemonBaseMapper pokemonBaseMapper;


    @Override
    public CustomPage<PokemonBase> findAllPage(PageQuery pageable) {
        NamedApiResourceList<Pokemon> resource = pokeApiClient.getResource(Pokemon.class,pageable).block();
        List<NamedApiResource<Pokemon>> results = resource.getResults();
        List<PokemonBase> pokemons = getBasePokemon(results);
        CustomPage<PokemonBase> result = new CustomPage<>();
        result.setResults(pokemons);
        result.setCount(resource.getCount());
        result.setNext(resource.getNext());
        result.setPrevious(resource.getPrevious());
        return result;
    }


    private List<PokemonBase> getBasePokemon(List<NamedApiResource<Pokemon>> results){
        List<Pokemon> pokemons = new LinkedList<Pokemon>();
        results.stream().forEach( p ->{
            Pokemon pokemon =  pokeApiClient.getResource(Pokemon.class , p.getName()).block();
            pokemons.add(pokemon);

        });
        List<PokemonBase> basicPokemons = pokemonBaseMapper.convert(pokemons);
        return basicPokemons;
    }


}
