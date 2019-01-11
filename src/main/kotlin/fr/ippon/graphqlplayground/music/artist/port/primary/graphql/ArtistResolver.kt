package fr.ippon.graphqlplayground.music.artist.port.primary.graphql

import com.coxautodev.graphql.tools.GraphQLResolver
import fr.ippon.graphqlplayground.music.artist.Album
import fr.ippon.graphqlplayground.music.artist.AlbumRepository
import fr.ippon.graphqlplayground.music.artist.Artist
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class ArtistResolver : GraphQLResolver<Artist> {

    @Autowired
    private lateinit var albumRepository: AlbumRepository

    fun albums(artist: Artist): List<Album> {
        return albumRepository.findByArtist(artist.id)
    }
}
