package com.example.pokedex.api

import com.example.pokedex.api.model.PokemonsApiResult
import com.example.pokedex.api.model.PokemonApiResult
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object PokemonRepository {
    private val service: PokemonService

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        service = retrofit.create(PokemonService::class.java) //implemantação dos metodos
    }

    fun listPokemons(limit: Int = 151): PokemonsApiResult? {
        val call = service.listPokemons(limit)

        return call.execute().body() // execução sincrona
    }

    fun getPokemon (number: Int): PokemonApiResult? {
        val call = service.getPokemon(number) // requisição http

        return call.execute().body() // execução sincrona
    }
}