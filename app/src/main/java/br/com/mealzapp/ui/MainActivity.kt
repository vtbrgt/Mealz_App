package br.com.mealzapp.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import br.com.mealzapp.ui.details.MealDetailsScreen
import br.com.mealzapp.ui.details.MealDetailsViewModel
import br.com.mealzapp.ui.meals.MealsCategoriesScreen
import br.com.mealzapp.ui.theme.MealzAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MealzAppTheme {
                FoodiezApp()
            }
        }
    }
}

@Composable
private fun FoodiezApp() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "meals_list") {
        composable(route = "meals_list") {
            MealsCategoriesScreen() { mealId ->
                navController.navigate("meal_details/$mealId")
            }
        }
        composable(route = "meal_details/{meal_id}", arguments = listOf(navArgument("meal_id") { type = NavType.StringType })) {
            val viewModel: MealDetailsViewModel = viewModel()
            MealDetailsScreen(viewModel.mealState.value)
        }
    }
}