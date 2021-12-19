package com.qbaillet.whereismytoiletlyonedition.Views.Composable

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.ProgressIndicatorDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
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
@Composable
fun LoadingList(){
    var progress by remember { mutableStateOf(0.1f) }
    val animatedProgress = animateFloatAsState(
        targetValue = progress,
        animationSpec = ProgressIndicatorDefaults.ProgressAnimationSpec
    ).value

    Column(horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Center) {
        CircularProgressIndicator(progress = animatedProgress)
    }
}