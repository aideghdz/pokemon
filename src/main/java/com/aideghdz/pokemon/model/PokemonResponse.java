package com.aideghdz.pokemon.model;


import lombok.*;
import skaro.pokeapi.resource.evolutionchain.EvolutionChain;


@Data
@EqualsAndHashCode(callSuper=false)
public class PokemonResponse extends  PokemonBase{

    private String description;
    private EvolutionChain evolutionDetail;
}
