package com.aideghdz.pokemon.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import skaro.pokeapi.resource.pokemon.PokemonAbility;

import java.util.List;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class PokemonBase {

    protected Integer id;
    protected String name;
    protected String photo;
    protected String type;
    protected Integer weight;
    protected List<PokemonAbility> abilities;

}
