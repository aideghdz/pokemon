package com.aideghdz.pokemon.model;


import lombok.*;
import lombok.experimental.SuperBuilder;
import skaro.pokeapi.resource.evolutionchain.EvolutionChain;


@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class PokemonResponse extends  PokemonBase{

    private String description;
    private EvolutionChain evolutionDetail;
}
