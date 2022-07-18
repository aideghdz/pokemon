package com.aideghdz.pokemon.controller;


import com.aideghdz.pokemon.model.PokemonBase;
import com.aideghdz.pokemon.service.PokemonService;
import com.aideghdz.pokemon.util.CustomPage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import skaro.pokeapi.query.PageQuery;
import skaro.pokeapi.resource.NamedApiResourceList;
import skaro.pokeapi.resource.pokemon.Pokemon;

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






}
