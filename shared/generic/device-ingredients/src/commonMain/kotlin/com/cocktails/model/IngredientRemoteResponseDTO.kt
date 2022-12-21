package com.cocktails.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class IngredientRemoteResponseDTO(
    @SerialName("id") val id: Long,
    @SerialName("name") val name: String,
    @SerialName("nameGrouped") val nameGrouped: String,
    @SerialName("nameModif") val nameModif: String,
    @SerialName("voltage") val voltage: Double = -1.0, // only for alcoholic
    @SerialName("preparation") val preparation: String = "", // only for non alcoholic
    @SerialName("desc") val desc: String,
    @SerialName("imgFileName") val imgFileName: String,
    @SerialName("videoUrl") val videoUrl: String,
    @SerialName("websiteUrl") val websiteUrl: String,
    @SerialName("tasteFK") val tasteFK: Long,
    @SerialName("numShowed") val numShowed: Long,
    @SerialName("dataCol") val dataCol: String,
    @SerialName("categoryFK") val categoryFK: Long,
    @SerialName("numKcal") val numKcal: Double,
    @SerialName("flags") val flags: String,
    @SerialName("type") val type: Long
)