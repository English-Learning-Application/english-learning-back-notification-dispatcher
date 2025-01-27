package com.security.app.repositories

import com.security.app.entities.CategoryCourse
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface CategoryCourseRepository : JpaRepository<CategoryCourse, UUID> {
    fun findAllByCategoryCategoryKeyIn(
        categoryKeys: List<String>,
    ): List<CategoryCourse>
}