package com.example.appharrypotter.data.model.mapper

import com.example.appharrypotter.data.model.database.CharacterEntity
import com.example.appharrypotter.data.model.database.WandEntity
import com.example.appharrypotter.domain.model.CharacterDomain
import com.example.appharrypotter.domain.model.WandDomain

fun CharacterEntity.toCharacterDomain() = CharacterDomain(
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

fun WandEntity.toWandDomain() = WandDomain(
    core = core,
    length = length,
    wood = wood )