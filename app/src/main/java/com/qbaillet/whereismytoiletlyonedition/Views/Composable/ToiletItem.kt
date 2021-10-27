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
import com.qbaillet.whereismytoiletlyonedition.Models.Toilet

@Composable
fun ToiletItem(toilet: Toilet) {
    Card(
        elevation = 10.dp, modifier = Modifier
            .padding(3.dp)
            .fillMaxWidth(), shape = RoundedCornerShape(5.dp)
    ) {
        Column(Modifier.padding(15.dp)) {
            Text(
                text = "${toilet.streetNumber} ${toilet.street}",
                style = MaterialTheme.typography.h6
            )
            Text(text = "${toilet.observation}", style = MaterialTheme.typography.subtitle2)

        }
    }

}