package br.com.mealzapp.model

import br.com.mealzapp.model.api.MealsWebService
import br.com.mealzapp.model.response.MealResponse
import br.com.mealzapp.model.response.MealsCategoriesResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MealzRepository(private val webService: MealsWebService = MealsWebService()) {
    private var cachedMeals = listOf<MealResponse>()
    suspend fun getMeals(): MealsCategoriesResponse {
        val response = webService.getMeals()
        cachedMeals = response.categories
        return response
    }

    fun getMeal(id: String?): MealResponse? {
        return cachedMeals.firstOrNull {
            it.id == id
        }
    }

    companion object {
        private var instance: MealzRepository? = null

        fun getInstance() = instance?: synchronized(this) {
            instance ?: MealzRepository().also { instance = it }
        }
    }
}