package com.security.app.repositories

import com.security.app.entities.LanguageCourseLearningContent
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface LanguageCourseLearningContentRepository : JpaRepository<LanguageCourseLearningContent, UUID> {
    fun findByLanguageCourseLearningContentId(languageCourseLearningContentId: UUID): LanguageCourseLearningContent?
}