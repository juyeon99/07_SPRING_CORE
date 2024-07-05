package com.ohgiraffers.section02.annotation.subsection02.qualifier;

import com.ohgiraffers.section02.annotation.common.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/*
* @Qualifier
* - 여러 개의 bean 객체 중에서 특정 bean 객체를 이름으로 지정하는 어노테이션
* - @Primary와 @Qualifier가 함께 쓰였을 때 @Qualifier가 우선순위
* */
@Service("pokemonServiceQualifier")
public class PokemonService {
    // 1. Field 주입 방식
//    @Qualifier("pikachu" /* = Pikachu -> 클래스명의 앞글자가 소문자로 들어감 */)
//    @Autowired
//    private Pokemon pokemon;
//
//    @Autowired
//    public PokemonService(Pokemon pokemon) {    // 3마리 중 어떤 포켓몬을 넣을지 primary로 우선순위 설정 해주어야 함
//        this.pokemon = pokemon;
//    }

    // 2. Constructor 주입 방식
    private Pokemon pokemon;

    @Autowired
    public PokemonService(@Qualifier("squirtle" /* = Squirtle */) Pokemon pokemon) {    // 3마리 중 어떤 포켓몬을 넣을지 primary로 우선순위 설정 해주어야 함
        this.pokemon = pokemon;
    }

    // -----------------------------------------
    public void pokemonAttack(){
        pokemon.attack();
    }
}
