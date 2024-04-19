package works.souljam.mock.repository

import org.springframework.data.jpa.repository.JpaRepository
import works.souljam.mock.entity.CodeEntity

interface CodeRepository : JpaRepository<CodeEntity, String>