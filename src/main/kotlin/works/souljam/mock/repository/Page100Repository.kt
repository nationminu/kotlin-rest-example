package works.souljam.mock.repository

import works.souljam.mock.entity.Page100Entity
import org.springframework.data.jpa.repository.JpaRepository

interface Page100Repository : JpaRepository<Page100Entity, String>