package com.qbaillet.whereismytoiletlyonedition.Views

import android.os.Build
import android.os.Bundle
import android.view.ViewGroup
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updateLayoutParams
import com.qbaillet.whereismytoiletlyonedition.Models.Toilet
import com.qbaillet.whereismytoiletlyonedition.Views.Composable.ToiletList
import com.qbaillet.whereismytoiletlyonedition.ui.theme.WhereIsMyToiletLyonEditionTheme
import kotlin.math.roundToInt

class ToiletListActivity : ComponentActivity() {
    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)


        setContent {
            WhereIsMyToiletLyonEditionTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    var toilets = getToilets()

                    val statusBarHeight = getStatusBarHeight()
                    ToiletList(toilets, statusBarHeight)
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

    private fun getToilets(): ArrayList<Toilet> {
        var toilets = ArrayList<Toilet>();
        var index = 0.toLong()

        for(i in 1 .. 25) {
            toilets.add(
                Toilet(
                    "Poleymieux au mont d'or", "Mairie", index,
                    "ToiletMaire", 1, 2, "Place de la mairie", i.toLong(), "Sur la place"
                )
            )
            index++
        }

        for(i in 1 .. 25) {
            toilets.add(
                Toilet(
                    "Curis au mont d'or", "Mairie", index,
                    "ToiletMaire", 1, 2, "Place de la mairie", i.toLong(), "Sur la place"
                )
            )
            index++
        }

        for(i in 1 .. 25) {
            toilets.add(
                Toilet(
                    "Lyon", "Mairie", index,
                    "ToiletMaire", 1, 2, "Place de la mairie", i.toLong(), "Sur la place"
                )
            )
            index++
        }

        return toilets
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