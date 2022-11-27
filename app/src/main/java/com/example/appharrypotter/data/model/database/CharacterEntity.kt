package com.example.appharrypotter.data.model.database

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tb_characters")
data class CharacterEntity(
    val actor: String,
    val alive: Boolean,
    val alternate_actors: List<String>,
    val alternate_names: List<String>,
    val ancestry: String,
    val dateOfBirth: String,
    val eyeColour: String,
    val gender: String,
    val hairColour: String,
    val hogwartsStaff: Boolean,
    val hogwartsStudent: Boolean,
    val house: String,
    val image: String,
    @PrimaryKey
    val name: String,
    val patronus: String,
    val species: String,
    @Embedded val wand: WandEntity?,
    val wizard: Boolean,
    val yearOfBirth: String
)