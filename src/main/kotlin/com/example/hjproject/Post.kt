//package com.example.hjproject
//
//import org.springframework.data.jpa.repository.JpaRepository
//import org.springframework.data.repository.findByIdOrNull
//import org.springframework.stereotype.Service
//import org.springframework.web.bind.annotation.*
//import javax.persistence.*
//import javax.transaction.Transactional
//
//// domain
//@Entity
//class Post(
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    val id: Long? = null,
//
//    @Column(length = 500, nullable = false)
//    var title: String,
//
//    @Column(columnDefinition = "TEXT", nullable = false)
//    var content: String,
//
//    val author: String? = null
//)
//
//// data jpa repository
//interface PostRepository : JpaRepository<Post, Long> {
//}
//
//// service
//@Service
//class PostService(
//    private val postRepository: PostRepository
//) {
//
//    @Transactional
//    fun save(requestDto: PostSaveRequestDto): Long? = postRepository.save(requestDto.toEntity()).id
//
//    @Transactional
//    fun update(id: Long, requestDto: PostUpdateRequestDto): Long? {
//        val post = postRepository.findByIdOrNull(id) ?: throw IllegalArgumentException("id = $id, 해당하는 게시글이 없습니다.")
//
//        post.title = requestDto.title
//        post.content = requestDto.content
//
//        return id
//    }
//
//    @Transactional
//    fun findPostById(id: Long): PostResponseDto {
//        val post = postRepository.findByIdOrNull(id) ?: throw IllegalArgumentException("id = $id, 해당하는 게시글이 없습니다.")
//        return PostResponseDto(post)
//    }
//}
//
//// controller
//@RestController
//class PostApiController(
//    private val postService: PostService
//) {
//
//    @GetMapping("/api/v1/post/{id}")
//    fun findPostById(@PathVariable id: Long): PostResponseDto = postService.findPostById(id)
//
//    @PostMapping("/api/v1/post")
//    fun save(@RequestBody requestDto: PostSaveRequestDto): Long? = postService.save(requestDto)
//
//    @PutMapping("/api/v1/post/{id}")
//    fun update(@PathVariable id: Long, @RequestBody requestDto: PostUpdateRequestDto): Long? =
//        postService.update(id, requestDto)
//}
//
//// dtos
//data class PostResponseDto(
//    val id: Long,
//    val title: String,
//    val content: String,
//    val author: String? = null
//){
//    constructor(post: Post) : this(
//        id = post.id!!,
//        title = post.title,
//        content = post.content,
//        author = post.author
//    )
//}
//
//data class PostSaveRequestDto(
//    val title: String,
//    val content: String,
//    val author: String? = null
//) {
//    fun toEntity(): Post = Post(
//        title = title,
//        content = content,
//        author = author
//    )
//}
//
//data class PostUpdateRequestDto(
//    val title: String = "",
//    val content: String = "",
//)