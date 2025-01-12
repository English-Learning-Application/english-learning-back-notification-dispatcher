package com.security.app.repositories

import com.security.app.entities.LanguageCourse
import com.security.app.model.Language
import com.security.app.model.LanguageLevel
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface LanguageCourseRepository : JpaRepository<LanguageCourse, UUID> {
    fun findByLanguage(language: Language): MutableList<LanguageCourse>
    fun findByLanguageAndLevel(language: Language, level: LanguageLevel): MutableList<LanguageCourse>
}