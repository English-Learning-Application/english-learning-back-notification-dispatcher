package com.security.app.controllers

import com.security.app.entities.LanguageCourse
import com.security.app.model.ListMessage
import com.security.app.services.LanguageCourseService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/courses")
class CourseController(
    private val languageCourseService: LanguageCourseService
) {
    @GetMapping("/{language}")
    fun getCourses(
        @PathVariable("language") language: String
    ): ResponseEntity<ListMessage<LanguageCourse>> {
        try {
            val courses = languageCourseService.getLanguageCourse(language)
            return ResponseEntity.ok(ListMessage.Success("Courses found", courses))
        } catch (e: IllegalArgumentException) {
            return ResponseEntity.badRequest().body(ListMessage.BadRequest("Language not found"))
        } catch (e: Exception) {
            return ResponseEntity.badRequest().body(ListMessage.BadRequest("Error occurred"))
        }
    }

    @GetMapping("/{language}/{level}")
    fun getCoursesByLanguageAndLevel(
        @PathVariable("language") language: String,
        @PathVariable("level") level: String
    ): ResponseEntity<ListMessage<LanguageCourse>> {
        try {
            val courses = languageCourseService.getLanguageCourseByLevelAndLanguage(language, level)
            return ResponseEntity.ok(ListMessage.Success("Courses found", courses))
        } catch (e: IllegalArgumentException) {
            return ResponseEntity.badRequest().body(ListMessage.BadRequest("Language not found"))
        } catch (e: Exception) {
            return ResponseEntity.badRequest().body(ListMessage.BadRequest("Error occurred"))
        }
    }

}