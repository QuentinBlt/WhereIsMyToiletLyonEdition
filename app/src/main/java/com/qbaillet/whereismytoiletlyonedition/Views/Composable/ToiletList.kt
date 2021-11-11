package com.qbaillet.whereismytoiletlyonedition.Views.Composable

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.qbaillet.whereismytoiletlyonedition.Models.Toilet
import com.qbaillet.whereismytoiletlyonedition.ui.theme.WhereIsMyToiletLyonEditionTheme

@RequiresApi(Build.VERSION_CODES.N)
@ExperimentalFoundationApi
@Composable
    fun ToiletList(toilets: ArrayList<Toilet>, statusBarHeight: Int){
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