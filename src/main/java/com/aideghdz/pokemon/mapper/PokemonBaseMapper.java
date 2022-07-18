package com.aideghdz.pokemon.mapper;


import com.aideghdz.pokemon.model.PokemonBase;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
import skaro.pokeapi.resource.pokemon.Pokemon;

import java.util.List;


@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface PokemonBaseMapper {

    PokemonBaseMapper INSTANCE = Mappers.getMapper(PokemonBaseMapper.class);

    @InheritConfiguration
    @Mappings({
            @Mapping(target = "photo", source = "sprites.frontDefault"),
            @Mapping(target = "type" , expression = "java( pokemon.getTypes().stream().findFirst().orElse(null).getType().getName())")
    })
    PokemonBase convert(Pokemon pokemon);

    @InheritInverseConfiguration
    List<PokemonBase> convert(List<Pokemon> pokemons);
}
