package com.example.heroeslist

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

// add @Parcelize above your data class declaration
// make your class extend Parcelable

@Parcelize
data class Hero(
    val name: String,
    val description: String,
    val superpower: String,
    val ranking: Int,
    val image: String
) : Parcelable, Comparable<Hero> {
    override fun compareTo(other: Hero): Int {
        // we decide the natural sorting order of out object
        // make it the ranking
        // this (current object), other (one we compare to)
        // negative if this comes before other
        // positive if this comes after other
        // zero if this and other are the same
        return this.ranking.compareTo(other.ranking)
    }
}
