package com.example.hjproject

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PostApiControllerTests(
    @Autowired private val postRepository: PostRepository,
    @Autowired private val restTemplate: TestRestTemplate,
    @LocalServerPort private val port: Int
) {
    val title = "title1"
    val content = "content1"

    @BeforeEach
    fun tearDown() {
        postRepository.deleteAll()
    }

    @Test
    fun savePost_shouldSuccess() {
        // given
        val requestDto = PostSaveRequestDto(
            title = title,
            content = content
        )
        val url = "http://localhost:${8080}/api/v1/post"

        // when
        val responseEntity: ResponseEntity<Long?> = restTemplate
            .postForEntity(url, requestDto, Long::class.java)
        // then
        assertThat(responseEntity.statusCode).isEqualTo(HttpStatus.OK)
        assertThat(responseEntity.headers.contentType).isEqualTo(MediaType.APPLICATION_JSON)

        val post = postRepository.findAll().first()
        assertThat(post.title).isEqualTo(title)
        assertThat(post.content).isEqualTo(content)
    }
}