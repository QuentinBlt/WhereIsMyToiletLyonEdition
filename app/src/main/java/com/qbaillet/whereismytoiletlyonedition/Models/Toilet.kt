package com.qbaillet.whereismytoiletlyonedition.Models

class Toilet(
    var town: String,
    var administrator: String,
    var gId: Long,
    var identifiant: String,
    var lat: Long,
    var lon: Long,
    var street: String,
    var streetNumber: Long?,
    var observation: String
)