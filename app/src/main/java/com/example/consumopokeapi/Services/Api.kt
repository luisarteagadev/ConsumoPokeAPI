package com.example.consumopokeapi.Services

import com.example.consumopokeapi.Model.PokemonResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

object Api {
    //url:https://pokeapi.co/api/v2/pokemon?limit=151
    //url base:"https://pokeapi.co/api/v2/"
    //method:"pokemon?limit=151"
    private val baseUrl:String="https://pokeapi.co/api/v2/"

    private val builder:Retrofit.Builder=Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
    interface  RemoteServices{
        @GET("pokemon")
        fun loadPokemon(@Query("limit") limit:Int):Call<PokemonResponse>
    }

    fun build():RemoteServices{

        return builder.build().create(RemoteServices::class.java)

    }

}