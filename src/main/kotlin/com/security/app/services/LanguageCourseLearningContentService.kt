package com.security.app.services

import com.security.app.entities.LanguageCourseLearningContent
import com.security.app.repositories.LanguageCourseLearningContentRepository
import com.security.app.utils.toUUID
import org.springframework.stereotype.Service

@Service
class LanguageCourseLearningContentService(
    private val languageCourseLearningContentRepository: LanguageCourseLearningContentRepository
) {
    fun getLanguageCourseLearningContent(
        languageCourseLearningContentId: String
    ): LanguageCourseLearningContent? {
        return languageCourseLearningContentRepository.findByLanguageCourseLearningContentId(
            languageCourseLearningContentId.toUUID()
        )
    }

    fun getLanguageCourseLearningContentByListOfLanguageCourseLearningContentId(
        listOfLanguageCourseLearningContentId: List<String>
    ): List<LanguageCourseLearningContent> {
        return languageCourseLearningContentRepository.findAllById(
            listOfLanguageCourseLearningContentId.map { it.toUUID() }
        )
    }
}