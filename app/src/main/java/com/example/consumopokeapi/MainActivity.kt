package com.example.consumopokeapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.consumopokeapi.Model.PokemonResponse
import com.example.consumopokeapi.Services.Api
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val tvResult:TextView=findViewById(R.id.tvResult)

        val request=Api.build().loadPokemon(151)
        request.enqueue(object : Callback<PokemonResponse>{
            override fun onResponse(
                call: Call<PokemonResponse>,
                response: Response<PokemonResponse>
            ) {

                val pokemonResponse=response.body()
                //.let si es que eso no es nulo, ejecuta lo que esta dentro de las llaves
                //if(Pokemon?.results?!=null)
                pokemonResponse?.results?.let {
                    it.forEach{
                        tvResult.append("${it.name}")
                        tvResult.append("\n")
                    }
                }

            }

            override fun onFailure(call: Call<PokemonResponse>, t: Throwable) {
                println(t.message)
            }

        })

    }
}