package com.security.app.repositories

import com.security.app.entities.Category
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface CategoryRepository : JpaRepository<Category, UUID> {
}