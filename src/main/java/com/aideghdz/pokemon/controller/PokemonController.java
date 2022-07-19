package com.aideghdz.pokemon.controller;


import com.aideghdz.pokemon.model.PokemonBase;
import com.aideghdz.pokemon.model.PokemonResponse;
import com.aideghdz.pokemon.service.PokemonService;
import com.aideghdz.pokemon.util.CustomPage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import skaro.pokeapi.query.PageQuery;

@Slf4j
@RestController
@RequestMapping("/pokemon")
public class PokemonController {

    @Autowired
    PokemonService pokemonService;

    @GetMapping(path = "/list")
    CustomPage<PokemonBase> getPokemonsByPage(@RequestParam(required = false, defaultValue="10" ) int limit
            ,@RequestParam(required = false, defaultValue="0") Integer offset) {
        PageQuery query = new PageQuery(limit,offset);
        return pokemonService.findAllPage(query);
    }

    @GetMapping(path = "/get/{id}")
    PokemonResponse getPokemonEvolutionInfo(@PathVariable String id) {
        return pokemonService.findPokemonDetailInfo(id);
    }






}
