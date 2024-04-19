package works.souljam.mock.repository

import works.souljam.mock.entity.Page200Entity
import org.springframework.data.jpa.repository.JpaRepository

interface Page200Repository : JpaRepository<Page200Entity, String>