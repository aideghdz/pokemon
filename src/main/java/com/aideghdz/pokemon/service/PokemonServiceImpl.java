package com.aideghdz.pokemon.service;

import com.aideghdz.pokemon.mapper.PokemonBaseMapper;
import com.aideghdz.pokemon.mapper.PokemonResponseMapper;
import com.aideghdz.pokemon.model.PokemonBase;
import com.aideghdz.pokemon.model.PokemonResponse;
import com.aideghdz.pokemon.util.CustomPage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import skaro.pokeapi.client.PokeApiClient;
import skaro.pokeapi.query.PageQuery;
import skaro.pokeapi.resource.ApiResource;
import skaro.pokeapi.resource.NamedApiResource;
import skaro.pokeapi.resource.NamedApiResourceList;
import skaro.pokeapi.resource.evolutionchain.EvolutionChain;
import skaro.pokeapi.resource.pokemon.Pokemon;
import skaro.pokeapi.resource.pokemonspecies.PokemonSpecies;
import org.springframework.web.reactive.function.client.WebClient;


import java.util.LinkedList;
import java.util.List;

@Slf4j
@Service
public class PokemonServiceImpl implements PokemonService{

    @Value("${pokemon.list.api}")
    private  String POKEMON_LIST_PATH  ;
    
    @Autowired
    private PokeApiClient pokeApiClient;

    @Autowired
    private PokemonBaseMapper pokemonBaseMapper;

    @Autowired
    private PokemonResponseMapper pokemonResponseMapper;

    @Autowired
    private WebClient webClient ;

    @Override
    public CustomPage<PokemonBase> findAllPage(PageQuery pageable) {
        NamedApiResourceList<Pokemon> resource = pokeApiClient.getResource(Pokemon.class,pageable).block();
        List<NamedApiResource<Pokemon>> results = new LinkedList<NamedApiResource<Pokemon>>();
        CustomPage<PokemonBase> result = new CustomPage<>();
        if(resource != null){
             results = resource.getResults();
             result.setCount(resource.getCount());
             result.setNext(buildResourcePath( resource.getNext()));
             result.setPrevious(buildResourcePath(resource.getPrevious()));
        }
        result.setResults(getBasePokemon(results));
        return result;
    }



    private List<PokemonBase> getBasePokemon(List<NamedApiResource<Pokemon>> results){
        List<Pokemon> pokemons = new LinkedList<Pokemon>();
        results.forEach( p ->{
            Pokemon pokemon =  pokeApiClient.getResource(Pokemon.class , p.getName()).block();
            pokemons.add(pokemon);

        });
        return  pokemonBaseMapper.convert(pokemons);
    }

    private String buildResourcePath( String oldUrl){
        oldUrl = oldUrl != null ? oldUrl : "";
        String params = oldUrl.substring(oldUrl.indexOf("?")+1);
        return  POKEMON_LIST_PATH + params;
    }

    @Override
    public PokemonResponse findPokemonDetailInfo(String id) {
        Pokemon pokemon =  pokeApiClient.getResource(Pokemon.class , id).block();
        PokemonSpecies specie = pokeApiClient.getResource(PokemonSpecies.class, pokemon.getName()).block();

        String description = specie.getFlavorTextEntries().stream().findFirst().get().getFlavorText();
        ApiResource<EvolutionChain> chainURl = specie.getEvolutionChain();
        EvolutionChain chain = getChainFromUrl(chainURl.getUrl());
        return pokemonResponseMapper.convert(pokemon,description,chain);
    }

    private EvolutionChain getChainFromUrl(String url) {
        EvolutionChain chain = webClient.get()
                .uri(url)
                .retrieve()
                .bodyToMono(EvolutionChain.class).block();
        return chain;
    }


}
