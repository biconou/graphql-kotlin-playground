package fr.ippon.graphqlplayground.musiclibrary.port.primary.graphql

import com.coxautodev.graphql.tools.GraphQLResolver
import fr.ippon.graphqlplayground.musiclibrary.Album
import fr.ippon.graphqlplayground.musiclibrary.AlbumRepository
import fr.ippon.graphqlplayground.musiclibrary.Artist
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class ArtistResolver(val albumRepository: AlbumRepository) : GraphQLResolver<Artist> {

    fun albums(artist: Artist): List<Album> {
        return albumRepository.findByArtist(artist.id)
    }
}
