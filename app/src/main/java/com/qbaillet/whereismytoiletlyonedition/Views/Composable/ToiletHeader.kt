package com.qbaillet.whereismytoiletlyonedition.Views.Composable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ToiletHeader(town: String) {
    Card(
        elevation = 20.dp, modifier = Modifier
            .fillMaxWidth(), shape = RoundedCornerShape(5.dp)
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