package com.qbaillet.whereismytoiletlyonedition.Views

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import com.qbaillet.whereismytoiletlyonedition.Models.Toilet
import com.qbaillet.whereismytoiletlyonedition.ViewModels.ToiletListViewModel
import com.qbaillet.whereismytoiletlyonedition.Views.Composable.LoadingList
import com.qbaillet.whereismytoiletlyonedition.Views.Composable.ToiletList
import com.qbaillet.whereismytoiletlyonedition.ui.theme.WhereIsMyToiletLyonEditionTheme
import kotlin.math.roundToInt

class ToiletListActivity : ComponentActivity() {

    private val viewModel by viewModels<ToiletListViewModel>()

    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        viewModel.load()
        setContent {
            WhereIsMyToiletLyonEditionTheme {
                val isLoading by viewModel.isLoading.collectAsState()
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    val statusBarHeight = getStatusBarHeight()
                    when{
                        isLoading -> LoadingList()
                        else -> ToiletList(viewModel.toilets.value, statusBarHeight)
                    }
                }
            }
        }
    }

    fun getStatusBarHeight(): Int {
        var result = 0
        val resourceId = resources.getIdentifier("status_bar_height", "dimen", "android")
        if (resourceId > 0) {
            result = resources.getDimensionPixelSize(resourceId)
        }
        val dpStatusBarHeight = result / getResources().getDisplayMetrics().density
        return dpStatusBarHeight.roundToInt()
    }
}

@ExperimentalFoundationApi
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    WhereIsMyToiletLyonEditionTheme {
        var toilets = ArrayList<Toilet>();
        toilets.add(
            Toilet(
                "Poleymieux au mont d'or", "Mairie", 1,
                "ToiletMaire", 1, 2, "Place de la mairie", 7, "Sur la place"
            )
        )

        toilets.add(
            Toilet(
                "Poleymieux au mont d'or", "Mairie", 1,
                "ToiletMaire", 1, 2, "Place de la mairie", 7, "Sur la place"
            )
        )

        toilets.add(
            Toilet(
                "Poleymieux au mont d'or", "Mairie", 1,
                "ToiletMaire", 1, 2, "Place de la mairie", 7, "Sur la place"
            )
        )

        ToiletList(toilets, 25)
    }
}

@ExperimentalFoundationApi
@Preview(showBackground = true)
@Composable
fun LoadingPreview(){
    WhereIsMyToiletLyonEditionTheme {
        LoadingList()
    }
}