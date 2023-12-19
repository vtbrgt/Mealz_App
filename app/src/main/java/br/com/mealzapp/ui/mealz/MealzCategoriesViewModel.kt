package br.com.mealzapp.ui.mealz

import androidx.lifecycle.ViewModel
import br.com.mealzapp.model.MealzRepository
import br.com.mealzapp.model.response.MealResponse

class MealzCategoriesViewModel (private val repository: MealzRepository = MealzRepository()): ViewModel() {
    fun getMeals(): List<MealResponse> {
        return repository.getMeals().categories
    }
}