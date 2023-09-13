package com.bps_e.pokeapi

import kotlinx.coroutines.runBlocking
import org.junit.Test

class PokeApiTest {
    @Test
    fun pokemonTest() {
        runBlocking {
            PokeApi.Pokemon(limit = 1, onError = {
                println(it.toString())
                assert(false)
            }) {
                println("${it.count} ${PokeApiHelper.ConvertOffset(it.next!!)}")
            }

            PokeApi.Pokemon(name = "1", onError = {
                println(it.toString())
                assert(false)
            }) {
                println(it.name)
            }
        }
    }

    @Test
    fun pokemonSpeciesTest() {
        runBlocking {
            PokeApi.PokemonSpecies(name = "1", onError = {
                println(it.toString())
                assert(false)
            }) {
                println("${it.name} ${PokeApiHelper.ConvertGanderRate(it.gender_rate)}")
            }
        }
    }

    @Test
    fun typeTest() {
        runBlocking {
            PokeApi.Type(onError = {
                println(it.toString())
                assert(false)
            }) {
                println("${it.count}")
            }

            PokeApi.Type(name = "1", onError = {
                println(it.toString())
                assert(false)
            }) {
                println(it.name)
            }
        }
    }

    @Test
    fun abilityTest() {
        runBlocking {
            PokeApi.Ability(onError = {
                println(it.toString())
                assert(false)
            }) {
                println("${it.count}")
            }

            PokeApi.Ability(name = "1", onError = {
                println(it.toString())
                assert(false)
            }) {
                println(it.name)
            }
        }
    }

    @Test
    fun moveTest() {
        runBlocking {
            PokeApi.Move(onError = {
                println(it.toString())
                assert(false)
            }) {
                println("${it.count}")
            }

            PokeApi.Move(name = "1", onError = {
                println(it.toString())
                assert(false)
            }) {
                println(it.name)
            }
        }
    }

    @Test
    fun statTest() {
        runBlocking {
            PokeApi.Stat(onError = {
                println(it.toString())
                assert(false)
            }) {
                println("${it.count}")
            }

            PokeApi.Stat(name = "1", onError = {
                println(it.toString())
                assert(false)
            }) {
                println(it.name)
            }
        }
    }
}