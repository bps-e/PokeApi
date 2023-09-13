/**
 * Copyright 2023 bps-e.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.bps_e.pokeapi

import com.bps_e.HttpClient

@Suppress("RedundantVisibilityModifier", "unused")
public class PokeApi {
    public suspend inline fun <reified T> api(
        api: String,
        limit: Int = 0,
        offset: Int = -1,
        noinline onError: (e: Exception) -> Unit,
        noinline onCompleted: (T) -> Unit
    ) {
        var params = ""
        if (limit > 0) params = "limit=$limit"
        if (offset >= 0) {
            params = if (params.isEmpty()) "offset=$offset" else "$params&offset=$offset"
        }

        val url = if (params.isEmpty()) api else "$api?$params"
        HttpClient.Api<T>(url, onError) { code, data ->
            if (code == HttpClient.OK) onCompleted(data)
            else onError(Exception("responseCode=$code"))
        }
    }

    @Suppress("FunctionName")
    companion object {
        private const val baseUrl = "https://pokeapi.co/api/v2"

        /**
         * ポケモンの総数と名前(英語)のリストを取得
         */
        public suspend fun Pokemon(
            api: String = "$baseUrl/pokemon",
            limit: Int = 10000,
            offset: Int = 0,
            onError: (e: Exception) -> Unit = {},
            onCompleted: (resource: PokeApiData.ResourceList) -> Unit
        ) {
            PokeApi().api<PokeApiData.ResourceList>(api, limit, offset, onError, onCompleted)
        }

        /**
         * ポケモンの名前(英語)またはidからポケモンの情報を取得
         */
        public suspend fun Pokemon(
            name: String,
            api: String = "$baseUrl/pokemon",
            onError: (e: Exception) -> Unit = {},
            onCompleted: (pokemon: PokeApiData.Pokemon) -> Unit
        ) {
            val url = if (name.isEmpty()) api else "$api/$name"
            PokeApi().api<PokeApiData.Pokemon>(url, onError = onError, onCompleted = onCompleted)
        }

        /**
         * ポケモンの名前(英語)またはidからポケモンの情報を取得(日本名など)
         */
        public suspend fun PokemonSpecies(
            name: String,
            api: String = "$baseUrl/pokemon-species",
            onError: (e: Exception) -> Unit = {},
            onCompleted: (pokemon: PokeApiData.PokemonSpecies) -> Unit
        ) {
            val url = if (name.isEmpty()) api else "$api/$name"
            PokeApi().api<PokeApiData.PokemonSpecies>(url, onError = onError, onCompleted = onCompleted)
        }

        /**
         * タイプの総数と名前(英語)のリストを取得
         */
        public suspend fun Type(
            api: String = "$baseUrl/type",
            limit: Int = 1000,
            offset: Int = 0,
            onError: (e: Exception) -> Unit = {},
            onCompleted: (resource: PokeApiData.ResourceList) -> Unit
        ) {
            PokeApi().api<PokeApiData.ResourceList>(api, limit, offset, onError, onCompleted)
        }

        /**
         * タイプの名前(英語)またはidからタイプの情報を取得(日本名など)
         */
        public suspend fun Type(
            name: String,
            api: String = "$baseUrl/type",
            onError: (e: Exception) -> Unit = {},
            onCompleted: (type: PokeApiData.Type) -> Unit
        ) {
            val url = if (name.isEmpty()) api else "$api/$name"
            PokeApi().api<PokeApiData.Type>(url, onError = onError, onCompleted = onCompleted)
        }

        /**
         * 特性の総数と名前(英語)のリストを取得
         */
        public suspend fun Ability(
            api: String = "$baseUrl/ability",
            limit: Int = 10000,
            offset: Int = 0,
            onError: (e: Exception) -> Unit = {},
            onCompleted: (resource: PokeApiData.ResourceList) -> Unit
        ) {
            PokeApi().api<PokeApiData.ResourceList>(api, limit, offset, onError, onCompleted)
        }

        /**
         * 特性の名前(英語)またはidから特性の情報を取得(日本名など)
         */
        public suspend fun Ability(
            name: String,
            api: String = "$baseUrl/ability",
            onError: (e: Exception) -> Unit = {},
            onCompleted: (type: PokeApiData.Ability) -> Unit
        ) {
            val url = if (name.isEmpty()) api else "$api/$name"
            PokeApi().api<PokeApiData.Ability>(url, onError = onError, onCompleted = onCompleted)
        }

        /**
         * 技の総数と名前(英語)のリストを取得
         */
        public suspend fun Move(
            api: String = "$baseUrl/move",
            limit: Int = 10000,
            offset: Int = 0,
            onError: (e: Exception) -> Unit = {},
            onCompleted: (resource: PokeApiData.ResourceList) -> Unit
        ) {
            PokeApi().api<PokeApiData.ResourceList>(api, limit, offset, onError, onCompleted)
        }

        /**
         * 技の名前(英語)またはidから技の情報を取得(日本名など)
         */
        public suspend fun Move(
            name: String,
            api: String = "$baseUrl/move",
            onError: (e: Exception) -> Unit = {},
            onCompleted: (type: PokeApiData.Move) -> Unit
        ) {
            val url = if (name.isEmpty()) api else "$api/$name"
            PokeApi().api<PokeApiData.Move>(url, onError = onError, onCompleted = onCompleted)
        }

        /**
         * ステートの総数と名前(英語)のリストを取得
         */
        public suspend fun Stat(
            api: String = "$baseUrl/stat",
            limit: Int = 100,
            offset: Int = 0,
            onError: (e: Exception) -> Unit = {},
            onCompleted: (resource: PokeApiData.ResourceList) -> Unit
        ) {
            PokeApi().api<PokeApiData.ResourceList>(api, limit, offset, onError, onCompleted)
        }

        /**
         * ステートの名前(英語)またはidからステートの情報を取得(日本名など)
         */
        public suspend fun Stat(
            name: String,
            api: String = "$baseUrl/stat",
            onError: (e: Exception) -> Unit = {},
            onCompleted: (type: PokeApiData.Stat) -> Unit
        ) {
            val url = if (name.isEmpty()) api else "$api/$name"
            PokeApi().api<PokeApiData.Stat>(url, onError = onError, onCompleted = onCompleted)
        }
    }
}
