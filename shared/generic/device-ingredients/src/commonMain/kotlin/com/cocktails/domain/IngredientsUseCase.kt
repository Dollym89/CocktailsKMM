package com.cocktails.domain

import clv.library.coroutines.domain.UnitSuspendUseCase
import clv.library.logger.infrastructure.logD
import com.cocktails.model.Ingredient
import com.example.network.model.ApiResponse
import com.example.network.model.ApiResponse.Error.NetworkError

public sealed class IngredientsUseCase {
    public class LoadAll(
        private val ingredientsRepository: IngredientsRepository,
    ) : UnitSuspendUseCase<Result>() {
        override suspend fun invoke(): Result {
            return when (val ingredients = ingredientsRepository.loadAll()) {
                is ApiResponse.Success -> Result.Success(ingredients = ingredients.data)
                is NetworkError -> {
                    logD("Ingredients failed to download; Error: $RESPONSE_NO_INTERNET")
                    Result.NoInternet
                }
                else -> {
                    Result.Failure
                }
            }
        }
    }

    private companion object {
        private const val RESPONSE_NO_INTERNET: String = "NOINTERNET"
    }

    public sealed class Result {
        public object Failure : Result()
        public object NoInternet : Result()
        public data class Success(public val ingredients: List<Ingredient>) : Result()
    }
}
