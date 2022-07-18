package com.aideghdz.pokemon.model;


import lombok.*;


@Data
@EqualsAndHashCode(callSuper=false)
public class Pokemon extends  PokemonBase{

    private String description;
    private EvolutionDetail evolutionDetail;
}
