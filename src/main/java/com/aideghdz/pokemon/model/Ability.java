package com.aideghdz.pokemon.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Ability {

    private Long id;
    private String name;
}
