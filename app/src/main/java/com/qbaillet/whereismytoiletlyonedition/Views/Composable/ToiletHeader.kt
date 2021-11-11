package com.qbaillet.whereismytoiletlyonedition.Views.Composable

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.qbaillet.whereismytoiletlyonedition.ui.theme.WhereIsMyToiletLyonEditionTheme

@ExperimentalFoundationApi
@Preview(showBackground = true)
@Composable
fun DefaultPreviewToiletHeader() {
    WhereIsMyToiletLyonEditionTheme {
        ToiletHeader(town = "Poleymieux au mont d'or", 25)
    }
}

@Composable
fun ToiletHeader(town: String, statusBarHeight: Int) {
    Column(
        modifier = Modifier.offset(y = statusBarHeight.dp)
    ) {
        Card(
            elevation = 20.dp, modifier = Modifier
                .fillMaxWidth(),

            shape = RoundedCornerShape(5.dp)
        ) {
            Column(Modifier.padding(15.dp)) {
                Text(
                    text = town,
                    modifier = Modifier.padding(10.dp),
                    style = MaterialTheme.typography.subtitle1
                )

            }
        }
    }

}