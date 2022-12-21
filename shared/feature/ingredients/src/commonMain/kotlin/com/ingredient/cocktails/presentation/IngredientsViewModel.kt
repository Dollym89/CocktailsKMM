package com.ingredient.cocktails.presentation

import clv.library.mvvm.presentation.BaseViewModel
import clv.library.mvvm.presentation.ViewModelState
import com.cocktails.domain.IngredientsUseCase
import com.cocktails.domain.IngredientsUseCase.Result.Success
import com.cocktails.model.Ingredient
import kotlinx.coroutines.launch

public class IngredientsViewModel(
    private val loadIngredients: IngredientsUseCase.LoadAll,
) : BaseViewModel<IngredientsViewModel.State>(State()) {

    init {
        viewModelScope.launch {
            when (val ingredients = loadIngredients()) {
                is Success -> state = state.copy(items = ingredients.ingredients)
                else -> {}
            }
        }
    }

    public data class State(
        public val items: List<Ingredient> = emptyList(),
    ) : ViewModelState
}
