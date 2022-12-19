package com.cocktails.data

import clv.library.architecture.infrastructure.Mapper
import com.cocktails.model.Ingredient
import com.cocktails.model.IngredientRemoteResponseDTO

// TODO: distinguish between DTO and actual Model
public class IngredientsDTORemoteConverter : Mapper<Ingredient, IngredientRemoteResponseDTO> {
    public override fun toDomain(external: IngredientRemoteResponseDTO): Ingredient =
        Ingredient(
            id = external.id,
            name = external.name,
            nameGrouped = external.nameGrouped,
            nameModif = external.nameModif,
            voltage = external.voltage,
            preparation = external.preparation,
            desc = external.desc,
            imgFileName = external.imgFileName,
            videoUrl = external.videoUrl,
            websiteUrl = external.websiteUrl,
            tasteFK = external.tasteFK,
            numShowed = external.numShowed,
            dataCol = external.dataCol,
            categoryFK = external.categoryFK,
            numKcal = external.numKcal,
            flags = external.flags,
            type = external.type
        )

    public override fun toExternal(domain: Ingredient): IngredientRemoteResponseDTO =
        IngredientRemoteResponseDTO(
            id = domain.id,
            name = domain.name,
            nameGrouped = domain.nameGrouped,
            nameModif = domain.nameModif,
            voltage = domain.voltage,
            preparation = domain.preparation,
            desc = domain.desc,
            imgFileName = domain.imgFileName,
            videoUrl = domain.videoUrl,
            websiteUrl = domain.websiteUrl,
            tasteFK = domain.tasteFK,
            numShowed = domain.numShowed,
            dataCol = domain.dataCol,
            categoryFK = domain.categoryFK,
            numKcal = domain.numKcal,
            flags = domain.flags,
            type = domain.type
        )
}
