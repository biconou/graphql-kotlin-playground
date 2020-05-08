package fr.ippon.graphqlplayground.musiclibrary.port.primary.graphql

import com.coxautodev.graphql.tools.GraphQLQueryResolver
import fr.ippon.graphqlplayground.musiclibrary.Artist
import fr.ippon.graphqlplayground.musiclibrary.ArtistRepository
import org.springframework.stereotype.Component

@Component
class QueryResolver(val repository: ArtistRepository) : GraphQLQueryResolver {

    fun artist(id: String): Artist? {
        return repository.findById(id)
    }
}
