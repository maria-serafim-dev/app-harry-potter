package com.example.appharrypotter.data.model.mapper

import com.example.appharrypotter.data.model.WandResponse
import com.example.appharrypotter.data.model.CharacterResponse
import com.example.appharrypotter.data.model.database.CharacterEntity
import com.example.appharrypotter.data.model.database.WandEntity

fun CharacterResponse.toCharacterEntity() = CharacterEntity(
    actor  = actor,
    alive = alive,
    alternate_actors = alternate_actors,
    alternate_names = alternate_names,
    ancestry = ancestry,
    dateOfBirth = dateOfBirth,
    eyeColour = eyeColour,
    gender = gender,
    hairColour = hairColour,
    hogwartsStaff = hogwartsStaff,
    hogwartsStudent = hogwartsStudent,
    house = house,
    image = image,
    name = name,
    patronus = patronus,
    species = species,
    wand = wand?.toWandEntity(),
    wizard = wizard,
    yearOfBirth = yearOfBirth
)

fun WandResponse.toWandEntity() = WandEntity(core = core, length = length, wood = wood )