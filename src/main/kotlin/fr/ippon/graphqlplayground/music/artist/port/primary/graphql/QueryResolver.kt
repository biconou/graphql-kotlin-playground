package fr.ippon.graphqlplayground.music.artist.port.primary.graphql

import com.coxautodev.graphql.tools.GraphQLQueryResolver
import fr.ippon.graphqlplayground.music.artist.Artist
import fr.ippon.graphqlplayground.music.artist.ArtistRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class QueryResolver : GraphQLQueryResolver {

    @Autowired
    private lateinit var repository: ArtistRepository

    fun artist(id: String): Artist? {
        return repository.findById(id)
    }
}
