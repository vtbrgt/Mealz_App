package br.com.mealzapp.model

import br.com.mealzapp.model.response.MealsCategoriesResponse

class MealzRepository {
    fun getMeals(): MealsCategoriesResponse = MealsCategoriesResponse(arrayListOf())
}