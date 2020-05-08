package fr.ippon.graphqlplayground

import com.graphql.spring.boot.test.GraphQLTest
import com.graphql.spring.boot.test.GraphQLTestTemplate
import org.assertj.core.api.Assertions
import org.junit.Test
import org.junit.runner.RunWith
import org.skyscreamer.jsonassert.JSONAssert
import org.skyscreamer.jsonassert.JSONCompareMode
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@GraphQLTest
class GraphqlServiceApplicationTest {

    @Autowired
    private lateinit var graphQLTestTemplate: GraphQLTestTemplate

    @Test
    fun existingArtist() {
        // When
        val response = graphQLTestTemplate.postForResource("existingArtist.graphql")

        // Then
        Assertions.assertThat(response).isNotNull
        Assertions.assertThat(response.isOk).isTrue()
        val expectedResponseBody = """
            {
              "data": {
                "artist": {
                  "id": "01",
                  "name": "The Beatles",
                  "albums": [
                    {
                      "year": 1966
                    },
                    {
                      "year": 1965
                    },
                    {
                      "year": 1969
                    }
                  ]
                }
              }
            }
        """
        JSONAssert.assertEquals(expectedResponseBody, response.rawResponse.body, JSONCompareMode.LENIENT)
    }

    @Test
    fun nonExistingArtist() {
        // When
        val response = graphQLTestTemplate.postForResource("nonExistingArtist.graphql")

        // Then
        Assertions.assertThat(response).isNotNull
        Assertions.assertThat(response.isOk).isTrue()
        val expectedResponseBody = """
            {
               "data": {
                  "artist": null
               }
            }
        """
        JSONAssert.assertEquals(expectedResponseBody, response.rawResponse.body, JSONCompareMode.LENIENT)
    }

}