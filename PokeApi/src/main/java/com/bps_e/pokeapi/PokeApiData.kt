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

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Suppress("RedundantVisibilityModifier", "unused", "RemoveRedundantQualifierName", "PropertyName",
    "SpellCheckingInspection"
)
public object PokeApiData {
    @Serializable
    public data class Name (
        @SerialName("name") val name: String,
        @SerialName("url") val url: String,
    )

    @Serializable
    public data class ResourceList (
        @SerialName("count") val count: Int,
        @SerialName("next") val next: String?,
        @SerialName("previous") val previous: String?,
        @SerialName("results") val results: List<PokeApiData.Name>,
    )

    @Serializable
    public data class Pokemon(
        @SerialName("abilities") val abilities: List<Ability>,
        @SerialName("base_experience") val base_experience: Int,
        @SerialName("forms") val forms: List<PokeApiData.Name>,
        @SerialName("game_indices") val game_indices: List<GameIndex>,
        @SerialName("height") val height: Int,
        @SerialName("held_items") val held_items: List<HeldItem>,
        @SerialName("id") val id: Int,
        @SerialName("is_default") val is_default: Boolean,
        @SerialName("location_area_encounters") val location_area_encounters: String,
        @SerialName("moves") val moves: List<Move>,
        @SerialName("name") val name: String,
        @SerialName("order") val order: Int,
        @SerialName("past_types") val past_types: List<PastType>,
        @SerialName("species") val species: PokeApiData.Name,
        @SerialName("sprites") val sprites: Sprites,
        @SerialName("stats") val stats: List<Stat>,
        @SerialName("types") val types: List<Type>,
        @SerialName("weight") val weight: Int,
    ) {
//region Pokemon
        @Serializable
        public data class Ability(
            @SerialName("ability") val ability: PokeApiData.Name,
            @SerialName("is_hidden") val is_hidden: Boolean,
            @SerialName("slot") val count: Int,
        )

        @Serializable
        public data class GameIndex(
            @SerialName("game_index") val game_index: Int,
            @SerialName("version") val version: PokeApiData.Name,
        )

        @Serializable
        public data class HeldItem(
            @SerialName("item") val item: PokeApiData.Name,
            @SerialName("version_details") val version_details: List<VersionDetail>,
        ) {
            @Serializable
            public data class VersionDetail(
                @SerialName("rarity") val rarity: Int,
                @SerialName("version") val version: PokeApiData.Name,
            )
        }

        @Serializable
        public data class Move(
            @SerialName("move") val move: PokeApiData.Name,
            @SerialName("version_group_details") val version_details: List<VersionGroupDetail>,
        ) {
            @Serializable
            public data class VersionGroupDetail(
                @SerialName("level_learned_at") val level_learnde_at: Int,
                @SerialName("move_learn_method") val move_learn_method: PokeApiData.Name,
                @SerialName("version_group") val version_group: PokeApiData.Name,
            )
        }

        @Serializable
        public data class PastType(
            @SerialName("generation") val generation: PokeApiData.Name,
            @SerialName("types") val type: List<Type>,
        ) {
            @Serializable
            public data class Type(
                @SerialName("slot") val slot: Int,
                @SerialName("type") val type: PokeApiData.Name,
            )
        }

        @Serializable
        public data class Other(
            @SerialName("dream_world") val dream_world: DreamWord,
            @SerialName("home") val home: Home,
            @SerialName("official-artwork") val official_artwork: OfficialArtWork,
        ) {
            @Suppress("PropertyName")
            @Serializable
            public data class DreamWord(
                @SerialName("front_default") val front_default: String?,
                @SerialName("front_female") val front_female: String?,
            )

            @Suppress("PropertyName")
            @Serializable
            public data class Home(
                @SerialName("front_default") val front_default: String?,
                @SerialName("front_female") val front_female: String?,
                @SerialName("front_shiny") val front_shiny: String?,
                @SerialName("front_shiny_female") val front_shiny_female: String?,
            )

            @Suppress("PropertyName")
            @Serializable
            public data class OfficialArtWork(
                @SerialName("front_default") val front_default: String?,
                @SerialName("front_shiny") val front_shiny: String?,
            )
        }

        @Serializable
        public data class Versions(
            @SerialName("generation-i") val generation_i: GenerationI,
            @SerialName("generation-ii") val generation_ii: GenerationII,
            @SerialName("generation-iii") val generation_iii: GenerationIII,
            @SerialName("generation-iv") val generation_iv: GenerationIV,
            @SerialName("generation-v") val generation_v: GenerationV,
            @SerialName("generation-vi") val generation_vi: GenerationVI,
            @SerialName("generation-vii") val generation_vii: GenerationVII,
            @SerialName("generation-viii") val generation_viii: GenerationVIII,
        ) {
            @Serializable
            public data class GenerationI(
                @SerialName("red-blue") val blue: Generation,
                @SerialName("yellow") val yellow: Generation,
            ) {
                @Serializable
                public data class Generation(
                    @SerialName("back_default") val back_default: String?,
                    @SerialName("back_gray") val back_female: String?,
                    @SerialName("back_transparent") val back_transparent: String?,
                    @SerialName("front_default") val front_default: String?,
                    @SerialName("front_gray") val front_gray: String?,
                    @SerialName("front_transparent") val front_transparent: String?,
                )
            }

            @Serializable
            public data class GenerationII(
                @SerialName("crystal") val blue: Crystal,
                @SerialName("gold") val gold: Generation,
                @SerialName("silver") val silver: Generation,
            ) {
                @Serializable
                public data class Crystal(
                    @SerialName("back_default") val back_default: String?,
                    @SerialName("back_shiny") val back_shiny: String?,
                    @SerialName("back_shiny_transparent") val back_shiny_transparent: String?,
                    @SerialName("back_transparent") val back_transparent: String?,
                    @SerialName("front_default") val front_default: String?,
                    @SerialName("front_shiny") val front_shiny: String?,
                    @SerialName("front_shiny_transparent") val front_shiny_transparent: String?,
                    @SerialName("front_transparent") val front_transparent: String?,
                )

                @Serializable
                public data class Generation(
                    @SerialName("back_default") val back_default: String?,
                    @SerialName("back_shiny") val back_shiny: String?,
                    @SerialName("front_default") val front_default: String?,
                    @SerialName("front_shiny") val front_shiny: String?,
                    @SerialName("front_transparent") val front_transparent: String?,
                )
            }

            @Serializable
            public data class GenerationIII(
                @SerialName("emerald") val emerald: Emerald,
                @SerialName("firered-leafgreen") val firered_leafgreen: Generation,
                @SerialName("ruby-sapphire") val ruby_sapphire: Generation,
            ) {
                @Serializable
                public data class Emerald(
                    @SerialName("front_default") val front_default: String?,
                    @SerialName("front_shiny") val front_shiny: String?,
                )

                @Serializable
                public data class Generation(
                    @SerialName("back_default") val back_default: String?,
                    @SerialName("back_shiny") val back_shiny: String?,
                    @SerialName("front_default") val front_default: String?,
                    @SerialName("front_shiny") val front_shiny: String?,
                )
            }

            @Serializable
            public data class GenerationIV(
                @SerialName("diamond-pearl") val diamond_pearl: Generation,
                @SerialName("heartgold-soulsilver") val heartgold_soulsilver: Generation,
                @SerialName("platinum") val platinum: Generation,
            ) {
                @Serializable
                public data class Generation(
                    @SerialName("back_default") val back_default: String?,
                    @SerialName("back_female") val back_female: String?,
                    @SerialName("back_shiny") val back_shiny: String?,
                    @SerialName("back_shiny_female") val back_shiny_female: String?,
                    @SerialName("front_default") val front_default: String?,
                    @SerialName("front_female") val front_female: String?,
                    @SerialName("front_shiny") val front_shiny: String?,
                    @SerialName("front_shiny_female") val front_shiny_female: String?,
                )
            }

            @Suppress("PropertyName")
            @Serializable
            public data class GenerationV(
                @SerialName("black-white") val black_white: Generation,
            ) {
                @Serializable
                public data class Animated(
                    @SerialName("back_default") val back_default: String?,
                    @SerialName("back_female") val back_female: String?,
                    @SerialName("back_shiny") val back_shiny: String?,
                    @SerialName("back_shiny_female") val back_shiny_female: String?,
                    @SerialName("front_default") val front_default: String?,
                    @SerialName("front_female") val front_female: String?,
                    @SerialName("front_shiny") val front_shiny: String?,
                    @SerialName("front_shiny_female") val front_shiny_female: String?,
                )

                @Serializable
                public data class Generation(
                    @SerialName("animated") val animated: Animated,
                    @SerialName("back_default") val back_default: String?,
                    @SerialName("back_female") val back_female: String?,
                    @SerialName("back_shiny") val back_shiny: String?,
                    @SerialName("back_shiny_female") val back_shiny_female: String?,
                    @SerialName("front_default") val front_default: String?,
                    @SerialName("front_female") val front_female: String?,
                    @SerialName("front_shiny") val front_shiny: String?,
                    @SerialName("front_shiny_female") val front_shiny_female: String?,
                )
            }

            @Serializable
            public data class GenerationVI(
                @SerialName("omegaruby-alphasapphire") val omegaruby_alphasapphire: Generation,
                @SerialName("x-y") val x_y: Generation,
            ) {
                @Serializable
                public data class Generation(
                    @SerialName("front_default") val front_default: String?,
                    @SerialName("front_female") val front_female: String?,
                    @SerialName("front_shiny") val front_shiny: String?,
                    @SerialName("front_shiny_female") val front_shiny_female: String?,
                )
            }

            @Serializable
            public data class GenerationVII(
                @SerialName("icons") val icons: Icons,
                @SerialName("ultra-sun-ultra-moon") val ultra_sun_ultra_moon: Generation,
            ) {
                @Serializable
                public data class Icons(
                    @SerialName("front_default") val front_default: String?,
                    @SerialName("front_female") val front_female: String?,
                )

                @Serializable
                public data class Generation(
                    @SerialName("front_default") val front_default: String?,
                    @SerialName("front_female") val front_female: String?,
                    @SerialName("front_shiny") val front_shiny: String?,
                    @SerialName("front_shiny_female") val front_shiny_female: String?,
                )
            }

            @Serializable
            public data class GenerationVIII(
                @SerialName("icons") val icons: Icons,
            ) {
                @Serializable
                public data class Icons(
                    @SerialName("front_default") val front_default: String?,
                    @SerialName("front_female") val front_female: String?,
                )
            }
        }

        @Serializable
        public data class Sprites(
            @SerialName("back_default") val back_default: String?,
            @SerialName("back_female") val back_female: String?,
            @SerialName("back_shiny") val back_shiny: String?,
            @SerialName("back_shiny_female") val back_shiny_female: String?,
            @SerialName("front_default") val front_default: String?,
            @SerialName("front_female") val front_female: String?,
            @SerialName("front_shiny") val front_shiny: String?,
            @SerialName("front_shiny_female") val front_shiny_female: String?,
            @SerialName("other") val other: Pokemon.Other,
            @SerialName("versions") val versions: Pokemon.Versions,
        )

        @Serializable
        public data class Stat(
            @SerialName("base_stat") val base_stat: Int,
            @SerialName("effort") val effort: Int,
            @SerialName("stat") val stat: PokeApiData.Name,
        )

        @Serializable
        public data class Type(
            @SerialName("slot") val slot: Int,
            @SerialName("type") val type: PokeApiData.Name,
        )
//endregion Pokemon
    }

    @Serializable
    public data class PokemonSpecies(
        @SerialName("base_happiness") val base_happiness: Int,
        @SerialName("capture_rate") val capture_rate: Int,
        @SerialName("color") val color: PokeApiData.Name,
        @SerialName("egg_groups") val egg_groups: List<PokeApiData.Name>,
        @SerialName("evolution_chain") val evolution_chain: EvolutionChain,
        @SerialName("evolves_from_species") val evolves_from_species: PokeApiData.Name?,
        @SerialName("flavor_text_entries") val flavor_text_entries: List<FlavorText>,
        @SerialName("form_descriptions") val form_descriptions: List<Description>,
        @SerialName("forms_switchable") val forms_switchable: Boolean,
        @SerialName("gender_rate") val gender_rate: Int,
        @SerialName("genera") val genera: List<Genera>,
        @SerialName("generation") val generation: PokeApiData.Name,
        @SerialName("growth_rate") val growth_rate: PokeApiData.Name,
        @SerialName("habitat") val habitat: PokeApiData.Name?,
        @SerialName("has_gender_differences") val has_gender_differences: Boolean,
        @SerialName("hatch_counter") val hatch_counter: Int,
        @SerialName("id") val id: Int,
        @SerialName("is_baby") val is_baby: Boolean,
        @SerialName("is_legendary") val is_legendary: Boolean,
        @SerialName("is_mythical") val is_mythical: Boolean,
        @SerialName("name") val name: String,
        @SerialName("names") val names: List<Language>,
        @SerialName("order") val order: Int,
        @SerialName("pal_park_encounters") val pal_park_encounters: List<PalParkEncounter>,
        @SerialName("pokedex_numbers") val pokedex_numbers: List<PokedexNumber>,
        @SerialName("shape") val shape: PokeApiData.Name,
        @SerialName("varieties") val varieties: List<Variety>,
    ) {
//region PokemonSpecies
        @Serializable
        public data class EvolutionChain(
            @SerialName("url") val url: String,
        )

        @Serializable
        public data class FlavorText(
            @SerialName("flavor_text") val flavor_text: String,
            @SerialName("language") val language: PokeApiData.Name,
            @SerialName("version") val version: PokeApiData.Name,
        )

        @Serializable
        public data class Description(
            @SerialName("description") val description: String,
            @SerialName("language") val language: PokeApiData.Name,
        )

        @Serializable
        public data class Genera(
            @SerialName("genus") val genus: String,
            @SerialName("language") val language: PokeApiData.Name,
        )

        @Serializable
        public data class Language(
            @SerialName("language") val language: PokeApiData.Name,
            @SerialName("name") val name: String,
        )

        @Serializable
        public data class PalParkEncounter(
            @SerialName("area") val area: PokeApiData.Name,
            @SerialName("base_score") val base_score: Int,
            @SerialName("rate") val rate: Int,
        )

        @Serializable
        public data class PokedexNumber(
            @SerialName("entry_number") val entry_number: Int,
            @SerialName("pokedex") val pokedex: PokeApiData.Name,
        )

        @Serializable
        public data class Variety(
            @SerialName("is_default") val is_default: Boolean,
            @SerialName("pokemon") val pokemon: PokeApiData.Name,
        )
//endregion PokemonSpecies
    }

    /** タイプ */
    @Serializable
    public data class Type(
        @SerialName("damage_relations") val damage_relations: DamageRelations,
        @SerialName("game_indices") val game_indices: List<GameIndex>,
        @SerialName("generation") val generation: PokeApiData.Name,
        @SerialName("id") val id: Int,
        @SerialName("move_damage_class") val move_damage_class: PokeApiData.Name?,
        @SerialName("moves") val moves: List<PokeApiData.Name>,
        @SerialName("name") val name: String,
        @SerialName("names") val names: List<Type.Name>,
        @SerialName("past_damage_relations") val past_damage_relations: List<PastDamageRelations>,
        @SerialName("pokemon") val pokemon: List<Type.Pokemon>,
    ) {
//region Type
        @Serializable
        public data class DamageRelations(
            @SerialName("double_damage_from") val double_damage_from: List<PokeApiData.Name>,
            @SerialName("double_damage_to") val double_damage_to: List<PokeApiData.Name>,
            @SerialName("half_damage_from") val half_damage_from: List<PokeApiData.Name>,
            @SerialName("half_damage_to") val half_damage_to: List<PokeApiData.Name>,
            @SerialName("no_damage_from") val no_damage_from: List<PokeApiData.Name>,
            @SerialName("no_damage_to") val no_damage_to: List<PokeApiData.Name>,
        )

        @Serializable
        public data class GameIndex(
            @SerialName("game_index") val game_index: Int,
            @SerialName("generation") val version: PokeApiData.Name,
        )

        @Serializable
        public data class Name(
            @SerialName("language") val language: PokeApiData.Name,
            @SerialName("name") val name: String,
        )

        @Serializable
        public data class PastDamageRelations(
            @SerialName("damage_relations") val damage_relations: DamageRelations,
            @SerialName("generation") val generation: PokeApiData.Name,
        ) {
            @Serializable
            public data class DamageRelations(
                @SerialName("double_damage_from") val double_damage_from: List<PokeApiData.Name>,
                @SerialName("double_damage_to") val double_damage_to: List<PokeApiData.Name>,
                @SerialName("half_damage_from") val half_damage_from: List<PokeApiData.Name>,
                @SerialName("half_damage_to") val half_damage_to: List<PokeApiData.Name>,
                @SerialName("no_damage_from") val no_damage_from: List<PokeApiData.Name>,
                @SerialName("no_damage_to") val no_damage_to: List<PokeApiData.Name>,
            )
        }

        @Serializable
        public data class Pokemon(
            @SerialName("pokemon") val generation: PokeApiData.Name,
            @SerialName("slot") val game_index: Int,
        )
//endregion Type
    }

    /** 特性 */
    @Serializable
    public data class Ability(
        @SerialName("effect_changes") val effect_changes: List<EffectChange>,
        @SerialName("effect_entries") val effect_entries: List<Effect>,
        @SerialName("flavor_text_entries") val flavor_text_entries: List<FlavorTextEntry>,
        @SerialName("generation") val generation: PokeApiData.Name,
        @SerialName("id") val id: Int,
        @SerialName("is_main_series") val is_main_series: Boolean,
        @SerialName("name") val name: String,
        @SerialName("names") val names: List<Language>,
        @SerialName("pokemon") val pokemon: List<Ability.Pokemon>,
    ) {
//region Ability
        @Serializable
        public data class EffectChange(
            @SerialName("effect_entries") val effect_entries: List<Effect>,
            @SerialName("version_group") val version_group: PokeApiData.Name,
        ) {
            @Serializable
            public data class Effect(
                @SerialName("effect") val effect: String,
                @SerialName("language") val language: PokeApiData.Name,
            )
        }

        @Serializable
        public data class Effect(
            @SerialName("effect") val effect: String,
            @SerialName("language") val language: PokeApiData.Name,
            @SerialName("short_effect") val short_effect: String,
        )

        @Serializable
        public data class FlavorTextEntry(
            @SerialName("flavor_text") val effect: String,
            @SerialName("language") val language: PokeApiData.Name,
            @SerialName("version_group") val version_group: PokeApiData.Name,
        )

        @Serializable
        public data class Language(
            @SerialName("language") val language: PokeApiData.Name,
            @SerialName("name") val name: String,
        )

        @Serializable
        public data class Pokemon(
            @SerialName("is_hidden") val is_hidden: Boolean,
            @SerialName("pokemon") val generation: PokeApiData.Name,
            @SerialName("slot") val game_index: Int,
        )
//endregion Ability
    }

    /** 技 */
    @Serializable
    public data class Move(
        @SerialName("accuracy") val accuracy: Int,
        @SerialName("contest_combos") val contest_combos: ContestCombos,
        @SerialName("contest_effect") val contest_effect: ContestEffect,
        @SerialName("contest_type") val contest_type: PokeApiData.Name,
        @SerialName("damage_class") val damage_class: PokeApiData.Name,
        @SerialName("effect_chance") val effect_chance: Int?,
        @SerialName("effect_changes") val effect_changes: List<EffectChange>,
        @SerialName("effect_entries") val effect_entries: List<EffectEntry>,
        @SerialName("flavor_text_entries") val flavor_text_entries: List<FlavorTextEntry>,
        @SerialName("generation") val generation: PokeApiData.Name,
        @SerialName("id") val id: Int,
        @SerialName("learned_by_pokemon") val learned_by_pokemon: List<PokeApiData.Name>,
        @SerialName("machines") val machines: List<Machine>,
        @SerialName("meta") val meta: Meta,
        @SerialName("name") val name: String,
        @SerialName("names") val names: List<Move.Name>,
        @SerialName("past_values") val past_values: List<PastValue>,
        @SerialName("power") val power: Int,
        @SerialName("pp") val pp: Int,
        @SerialName("priority") val priority: Int,
        @SerialName("stat_changes") val stat_changes: List<StatChange>,
        @SerialName("super_contest_effect") val super_contest_effect: SuperContestEffect,
        @SerialName("target") val target: PokeApiData.Name,
        @SerialName("type") val type: PokeApiData.Name,
    ) {
//region Move
        @Serializable
        public data class ContestCombos(
            @SerialName("normal") val normal: Normal,
            @SerialName("super") val _super: Super,
        ) {
            @Serializable
            public data class Normal(
                @SerialName("use_after") val use_after: List<PokeApiData.Name>?,
                @SerialName("use_before") val use_before: List<PokeApiData.Name>?,
            )

            @Serializable
            public data class Super(
                @SerialName("use_after") val use_after: List<PokeApiData.Name>?,
                @SerialName("use_before") val use_before: List<PokeApiData.Name>?,
            )
        }

        @Serializable
        public data class ContestEffect(
            @SerialName("url") val url: String,
        )

        @Serializable
        public data class EffectChange(
            @SerialName("effect_entries") val effect_entries: List<EffectChange.EffectEntry>,
            @SerialName("version_group") val version_group: PokeApiData.Name,
        ) {
            @Serializable
            public data class EffectEntry(
                @SerialName("effect") val url: String,
                @SerialName("language") val language: PokeApiData.Name,
            )
        }

        @Serializable
        public data class EffectEntry(
            @SerialName("effect") val effect: String,
            @SerialName("language") val language: PokeApiData.Name,
            @SerialName("short_effect") val short_effect: String,
        )

        @Serializable
        public data class FlavorTextEntry(
            @SerialName("flavor_text") val flavor_text: String,
            @SerialName("language") val language: PokeApiData.Name,
            @SerialName("version_group") val version_group: PokeApiData.Name,
        )

        @Serializable
        public data class Machine(
            @SerialName("machine") val machine: Machine_,
            @SerialName("version_group") val version_group: PokeApiData.Name,
        ) {
            @Suppress("ClassName")
            @Serializable
            public data class Machine_(
                @SerialName("url") val url: String,
            )
        }

        @Serializable
        public data class Meta(
            @SerialName("ailment") val ailment: PokeApiData.Name,
            @SerialName("ailment_chance") val ailment_chance: Int?,
            @SerialName("category") val category: PokeApiData.Name,
            @SerialName("crit_rate") val crit_rate: Int?,
            @SerialName("drain") val drain: Int?,
            @SerialName("flinch_chance") val flinch_chance: Int?,
            @SerialName("healing") val healing: Int?,
            @SerialName("max_hits") val max_hits: Int?,
            @SerialName("max_turns") val max_turns: Int?,
            @SerialName("min_hits") val min_hits: Int?,
            @SerialName("min_turns") val min_turns: Int?,
            @SerialName("stat_chance") val stat_chance: Int?,
        )

        @Serializable
        public data class Name(
            @SerialName("language") val language: PokeApiData.Name,
            @SerialName("name") val name: String,
        )

        @Serializable
        public data class PastValue(
            @SerialName("accuracy") val accuracy: Int?,
            @SerialName("effect_chance") val effect_chance: Int?,
            @SerialName("effect_entries") val effect_entries: List<PokeApiData.Name>,
            @SerialName("power") val power: Int?,
            @SerialName("pp") val pp: Int?,
            @SerialName("type") val type: PokeApiData.Name?,
        )

        @Serializable
        public data class StatChange(
            @SerialName("change") val change: PokeApiData.Name,
            @SerialName("stat") val stat: Int,
        )

        @Serializable
        public data class SuperContestEffect(
            @SerialName("url") val url: String,
        )

//endregion Move
    }

    /** ステート */
    @Serializable
    public data class Stat(
        @SerialName("affecting_moves") val affecting_moves: AffectingMoves,
        @SerialName("affecting_natures") val affecting_natures: AffectingNatures,
        @SerialName("characteristics") val characteristics: List<Characteristic>,
        @SerialName("game_index") val game_index: Int,
        @SerialName("id") val id: Int,
        @SerialName("is_battle_only") val is_battle_only: Boolean,
        @SerialName("move_damage_class") val move_damage_class: PokeApiData.Name?,
        @SerialName("name") val name: String,
        @SerialName("names") val names: List<Move.Name>,
    ) {
//region Stat
        @Serializable
        public data class AffectingMoves(
            @SerialName("decrease") val decrease: List<Decrease>,
            @SerialName("increase") val increase: List<Increase>,
        ) {
            @Serializable
            public data class Decrease(
                @SerialName("change") val change: Int,
                @SerialName("move") val move: List<PokeApiData.Name>,
            )

            @Serializable
            public data class Increase(
                @SerialName("change") val change: Int,
                @SerialName("move") val move: List<PokeApiData.Name>,
            )
        }

        @Serializable
        public data class AffectingNatures(
            @SerialName("decrease") val decrease: List<PokeApiData.Name>,
            @SerialName("increase") val increase: List<PokeApiData.Name>,
        )

        @Serializable
        public data class Characteristic(
            @SerialName("url") val url: String,
        )

        @Serializable
        public data class Name(
            @SerialName("language") val language: PokeApiData.Name,
            @SerialName("name") val name: String,
        )
//endregion Stat
    }
}