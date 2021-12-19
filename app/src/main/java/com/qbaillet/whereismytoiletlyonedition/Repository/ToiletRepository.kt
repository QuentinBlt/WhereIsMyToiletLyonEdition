package com.qbaillet.whereismytoiletlyonedition.Repository

import androidx.compose.runtime.snapshots.SnapshotStateList
import com.qbaillet.whereismytoiletlyonedition.Models.Toilet

class ToiletRepository {

    fun getFakeToilets(): List<Toilet> {
        var toilets = ArrayList<Toilet>();
        var index = 0.toLong()

        Thread.sleep(15000)

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