package com.qbaillet.whereismytoiletlyonedition.Views

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.qbaillet.whereismytoiletlyonedition.Models.Toilet
import com.qbaillet.whereismytoiletlyonedition.Views.Composable.ToiletList
import com.qbaillet.whereismytoiletlyonedition.ui.theme.WhereIsMyToiletLyonEditionTheme

class ToiletListActivity : ComponentActivity() {
    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WhereIsMyToiletLyonEditionTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    var toilets = getToilets()

                    ToiletList(toilets)
                }
            }
        }
    }


    private fun getToilets(): ArrayList<Toilet> {
        var toilets = ArrayList<Toilet>();

        for(i in 1 .. 25) {
            toilets.add(
                Toilet(
                    "Poleymieux au mont d'or", "Mairie", 1,
                    "ToiletMaire", 1, 2, "Place de la mairie", i.toLong(), "Sur la place"
                )
            )
        }

        for(i in 1 .. 25) {
            toilets.add(
                Toilet(
                    "Curis au mont d'or", "Mairie", 1,
                    "ToiletMaire", 1, 2, "Place de la mairie", i.toLong(), "Sur la place"
                )
            )
        }

        for(i in 1 .. 25) {
            toilets.add(
                Toilet(
                    "Lyon", "Mairie", 1,
                    "ToiletMaire", 1, 2, "Place de la mairie", i.toLong(), "Sur la place"
                )
            )
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

        ToiletList(toilets)
    }
}