package fr.ippon.graphqlplayground.musiclibrary

data class Artist(val id: String,val name: String) {

    var albums: List<Album>? = null
}