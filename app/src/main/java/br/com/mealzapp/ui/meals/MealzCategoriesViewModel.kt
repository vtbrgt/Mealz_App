package br.com.mealzapp.ui.meals

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.mealzapp.model.MealzRepository
import br.com.mealzapp.model.response.MealResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MealzCategoriesViewModel (private val repository: MealzRepository = MealzRepository.getInstance()): ViewModel() {
    val mealsState = mutableStateOf(emptyList<MealResponse>())

    init {
        viewModelScope.launch(Dispatchers.IO) {
            val meals = getMeals()
            mealsState.value = meals
        }
    }

    suspend fun getMeals(): List<MealResponse> {
        return repository.getMeals().categories
    }
}