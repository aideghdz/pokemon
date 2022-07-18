package com.aideghdz.pokemon.controller;


import com.aideghdz.pokemon.model.Pokemon;
import com.aideghdz.pokemon.service.PokemonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/pokemon")
public class PokemonController {

    @Autowired
    PokemonService pokemonService;

    @GetMapping(path = "/all")
    Page<Pokemon> getPokemonsByPage(Pageable pageable) {
        return pokemonService.findAllPage(pageable);
    }

  


}
