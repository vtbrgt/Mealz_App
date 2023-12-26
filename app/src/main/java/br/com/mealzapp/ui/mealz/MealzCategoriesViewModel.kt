package br.com.mealzapp.ui.mealz

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.mealzapp.model.MealzRepository
import br.com.mealzapp.model.response.MealResponse
import br.com.mealzapp.model.response.MealsCategoriesResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class MealzCategoriesViewModel (private val repository: MealzRepository = MealzRepository()): ViewModel() {
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