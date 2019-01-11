package fr.ippon.graphqlplayground.music.artist

import org.springframework.stereotype.Component

@Component
class ArtistRepository {

    fun findById(id: String): Artist? {
        var foundArtist: Artist? = null
        when (id) {
            "01" -> foundArtist = Artist(id = "01", name = "The Beatles")
            "02" -> foundArtist = Artist(id = "02", name = "The Rolling Stones")
        }
        return foundArtist
    }
}