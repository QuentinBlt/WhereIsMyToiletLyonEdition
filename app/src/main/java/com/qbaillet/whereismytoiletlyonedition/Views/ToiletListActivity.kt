package com.qbaillet.whereismytoiletlyonedition.Views

import android.R
import android.os.Build
import android.os.Bundle
import android.print.PrintAttributes
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.qbaillet.whereismytoiletlyonedition.Models.Toilet
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

@RequiresApi(Build.VERSION_CODES.N)
@ExperimentalFoundationApi
@Composable
fun ToiletList(toilets: ArrayList<Toilet>){
    LazyColumn(contentPadding = PaddingValues(12.dp)){
        val grouped = toilets.groupBy { it.town }
        grouped.forEach {town, toilets ->
            stickyHeader {
                ToiletHeader(town = town)
            }
            items(toilets) { toilet ->
                ToiletItem(toilet = toilet)
            }
        }

    }
}

@Composable
fun ToiletHeader(town: String) {
    Card(elevation = 20.dp, modifier = Modifier
        .fillMaxWidth(), shape = RoundedCornerShape(5.dp)
    ) {
        Column(Modifier.padding(15.dp)){
            Text(text = town,
                modifier = Modifier.padding(10.dp),
                style = MaterialTheme.typography.subtitle1)

        }
    }

}

@Composable
fun ToiletItem(toilet: Toilet) {
    Card(elevation = 10.dp, modifier = Modifier
        .padding(3.dp)
        .fillMaxWidth(), shape = RoundedCornerShape(5.dp)
    ) {
        Column(Modifier.padding(15.dp)){
            Text(text = "${toilet.streetNumber} ${toilet.street}", style = MaterialTheme.typography.h6)
            Text(text = "${toilet.observation}", style = MaterialTheme.typography.subtitle2)

        }
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