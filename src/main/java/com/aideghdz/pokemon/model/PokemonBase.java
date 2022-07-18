package com.aideghdz.pokemon.model;

import com.aideghdz.pokemon.model.response.PokemonAbility;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PokemonBase {

    protected Long id;
    protected String name;
    protected String photo;
    protected String type;
    protected Double weight;
    protected List<Ability> abilities;

}
