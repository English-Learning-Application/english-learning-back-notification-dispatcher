package com.security.app.entities

import com.fasterxml.jackson.annotation.JsonIgnore
import com.security.app.model.WordType
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
class Word {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    lateinit var wordId: UUID

    @Column(nullable = false)
    var englishWord: String = ""

    @Column(nullable = false)
    var vietnameseWord: String = ""

    @Column(nullable = false)
    var frenchWord: String = ""

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    var wordType: WordType = WordType.NOUN

    @Column
    var imageUrl: String? = null

    @Column(nullable = false)
    var pronunciation: String = ""

    @ManyToMany(mappedBy = "words", fetch = FetchType.LAZY)
    @JsonIgnore
    var languageCourseLearningContents: List<LanguageCourseLearningContent> = mutableListOf()

    @CreatedDate
    @Column(nullable = false, updatable = false)
    var createdAt: LocalDateTime = LocalDateTime.now()

    @LastModifiedDate
    @Column(nullable = false)
    var updatedAt: LocalDateTime = LocalDateTime.now()
}

