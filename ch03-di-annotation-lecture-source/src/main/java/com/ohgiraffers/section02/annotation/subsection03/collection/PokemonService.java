package com.ohgiraffers.section02.annotation.subsection03.collection;

import com.ohgiraffers.section02.annotation.common.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("pokemonServiceCollection")
public class PokemonService {
    // 1. List 타입으로 주입
//    private List<Pokemon> pokemonList;
//
//    @Autowired
//    public PokemonService(List<Pokemon> pokemonList) {
//        this.pokemonList = pokemonList;
//    }
//
//    public void pokemonAttack(){
//        for (Pokemon pokemon : pokemonList) {
//            pokemon.attack();
//        }
//
//        // 파이리 불꽃 공격🔥
//        // 피카츄 백만볼트⚡
//        // 꼬부기 물대포 발사🌊
//    }

    // 2. Map 타입으로 주입
    private Map<String, Pokemon> pokemonMap;

    @Autowired
    public PokemonService(Map<String, Pokemon> pokemonMap) {
        this.pokemonMap = pokemonMap;
    }

    public void pokemonAttack(){
        pokemonMap.forEach((k,v) -> {
            System.out.println("key: " + k);
            System.out.print("공격: ");
            v.attack();

            // key: charmander
            // 공격: 파이리 불꽃 공격🔥
            // key: pikachu
            // 공격: 피카츄 백만볼트⚡
            // key: squirtle
            // 공격: 꼬부기 물대포 발사🌊
        });
    }
}
