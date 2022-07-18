package com.aideghdz.pokemon.util;

import lombok.Data;

import java.util.List;

@Data
public class CustomPage<T> {

    private Integer count;
    private String next;
    private String previous;
    private List<T> results;
}
