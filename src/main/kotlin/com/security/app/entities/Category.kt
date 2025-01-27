package com.security.app.entities

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*
import lombok.*
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime
import java.util.*

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@ToString
@EntityListeners(AuditingEntityListener::class)
class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    lateinit var categoryId: UUID

    @Column(nullable = false)
    val categoryKey: String = ""

    @Column(nullable = false)
    val englishName: String = ""

    @Column(nullable = false)
    val vietnameseName: String = ""

    @Column(nullable = false)
    val frenchName: String = ""

    @Column(nullable = false)
    val englishDescription: String = ""

    @Column(nullable = false)
    val vietnameseDescription: String = ""

    @Column(nullable = false)
    val frenchDescription: String = ""

    @Column(nullable = false)
    val imageUrl: String = ""

    @OneToMany(mappedBy = "category", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    @JsonIgnore
    var categoryCourses: List<CategoryCourse> = mutableListOf()

    @CreatedDate
    @Column(nullable = false, updatable = false)
    var createdAt: LocalDateTime = LocalDateTime.now()

    @LastModifiedDate
    @Column(nullable = false)
    var updatedAt: LocalDateTime = LocalDateTime.now()
}