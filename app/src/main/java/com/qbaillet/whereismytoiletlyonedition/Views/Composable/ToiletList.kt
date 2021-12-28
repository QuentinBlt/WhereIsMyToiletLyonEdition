package com.qbaillet.whereismytoiletlyonedition.Views.Composable

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.qbaillet.whereismytoiletlyonedition.Models.Toilet
import com.qbaillet.whereismytoiletlyonedition.ui.theme.WhereIsMyToiletLyonEditionTheme

@RequiresApi(Build.VERSION_CODES.N)
@ExperimentalFoundationApi
@Composable
fun ToiletList(toilets: List<Toilet>, statusBarHeight: Int){
    LazyColumn(contentPadding = PaddingValues(12.dp)) {
        val grouped = toilets.groupBy { it.town }
        val lastTown = grouped.keys.last()
        val lastToilet = grouped[lastTown]?.last()
        var index = 0
        grouped.forEach { town, toilets ->
            stickyHeader {
                ToiletHeader(town = town, statusBarHeight)
            }
            items(toilets) { toilet ->

                ToiletItem(toilet = toilet, statusBarHeight,if(toilet.gId == lastToilet?.gId) statusBarHeight else 0)
            }
            index++
        }
    }
}



@RequiresApi(Build.VERSION_CODES.N)
@ExperimentalFoundationApi
@Preview(showBackground = true)
@Composable
fun LoadingList(){


    Column(horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(12.dp)
            .fillMaxWidth(),
    ) {
        Row(verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(12.dp)
                .fillMaxHeight(),
        ){
            Text("Récupération des toilettes", style = MaterialTheme.typography.h5)
            Divider(modifier = Modifier
                .fillMaxHeight()
                .width(5.dp), color = Color.Transparent)
            CircularProgressIndicator(color = MaterialTheme.colors.secondary)
        }
    }
}