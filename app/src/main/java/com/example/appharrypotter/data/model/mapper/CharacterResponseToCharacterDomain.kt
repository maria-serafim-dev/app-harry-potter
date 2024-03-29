package com.example.appharrypotter.data.model.mapper

import com.example.appharrypotter.data.model.CharacterResponse
import com.example.appharrypotter.data.model.WandResponse
import com.example.appharrypotter.domain.model.CharacterDomain
import com.example.appharrypotter.domain.model.WandDomain

fun CharacterResponse.toCharacterDomain() = CharacterDomain(
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
    wand = wand?.toWandDomain() ?: wandDomainEmpty(),
    wizard = wizard,
    yearOfBirth = yearOfBirth
)

fun WandResponse.toWandDomain() = WandDomain(core = core, length = length, wood = wood )

fun wandDomainEmpty() = WandDomain(core = "", length = "", wood = "")