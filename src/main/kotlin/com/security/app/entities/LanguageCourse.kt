package com.security.app.entities

import com.security.app.model.Language
import com.security.app.model.LanguageLevel
import com.security.app.model.LearningType
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
class LanguageCourse {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    lateinit var languageCourseId: UUID

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    var language: Language = Language.ENGLISH

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    var level: LanguageLevel = LanguageLevel.A1

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    var learningType: LearningType = LearningType.VOCABULARY

    @Column(nullable = false)
    var requiredSubscription: Boolean = false

    @OneToMany(mappedBy = "languageCourse", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    var languageCourseLearningContents: List<LanguageCourseLearningContent> = mutableListOf()

    @CreatedDate
    @Column(nullable = false, updatable = false)
    var createdAt: LocalDateTime = LocalDateTime.now()

    @LastModifiedDate
    @Column(nullable = false)
    var updatedAt: LocalDateTime = LocalDateTime.now()
}