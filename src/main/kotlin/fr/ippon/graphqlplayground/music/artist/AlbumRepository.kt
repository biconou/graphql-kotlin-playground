package fr.ippon.graphqlplayground.music.artist

import org.springframework.stereotype.Component

@Component
class AlbumRepository {

    fun findByArtist(artistId: String): List<Album> {
        var foundAlbums = mutableListOf<Album>()
        when (artistId) {
            "01" -> {
                foundAlbums.add(Album(title = "Revolver", year = 1966))
                foundAlbums.add(Album(title = "Help!", year = 1965))
            }
        }
        return foundAlbums
    }
}