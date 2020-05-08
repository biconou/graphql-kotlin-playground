package fr.ippon.graphqlplayground.musiclibrary

import org.springframework.stereotype.Component

@Component
class AlbumRepository {

    fun findByArtist(artistId: String): List<Album> {
        var foundAlbums = mutableListOf<Album>()
        when (artistId) {
            "01" -> {
                foundAlbums.add(Album(title = "Revolver", year = 1966))
                foundAlbums.add(Album(title = "Help!", year = 1965))
                foundAlbums.add(Album(title = "Abbey Road", year = 1969))
            }
            "02" -> {
                foundAlbums.add(Album(title = "Jazz", year = 1978))
                foundAlbums.add(Album(title = "A Kind of Magic", year = 1986))
            }
        }
        return foundAlbums
    }
}