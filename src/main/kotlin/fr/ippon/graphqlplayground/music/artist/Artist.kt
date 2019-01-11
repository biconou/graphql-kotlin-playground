package fr.ippon.graphqlplayground.music.artist

class Artist(val id: String,val name: String) {

    var albums: List<Album>? = null
}