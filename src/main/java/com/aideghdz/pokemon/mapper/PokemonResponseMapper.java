package com.aideghdz.pokemon.mapper;


import com.aideghdz.pokemon.model.PokemonResponse;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
import skaro.pokeapi.resource.ApiResource;
import skaro.pokeapi.resource.evolutionchain.EvolutionChain;
import skaro.pokeapi.resource.pokemon.Pokemon;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface PokemonResponseMapper {

    PokemonResponseMapper INSTANCE = Mappers.getMapper(PokemonResponseMapper.class);

    @InheritConfiguration
    @Mappings({
            @Mapping(target = "id", source = "pokemon.id"),
            @Mapping(target = "name", source = "pokemon.name"),
            @Mapping(target = "weight", source = "pokemon.weight"),
            @Mapping(target = "photo", source = "pokemon.sprites.frontDefault"),
            @Mapping(target = "type" , expression = "java( pokemon.getTypes().stream().findFirst().orElse(null).getType().getName())"),
            @Mapping(target = "description", source = "enDescription"),
            @Mapping(target = "evolutionDetail", source = "evolutionChain")
    })
    PokemonResponse convert(Pokemon pokemon, String enDescription , EvolutionChain evolutionChain );
}
