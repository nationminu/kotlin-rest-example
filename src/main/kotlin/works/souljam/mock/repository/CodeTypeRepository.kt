package works.souljam.mock.repository

import org.springframework.data.jpa.repository.JpaRepository
import works.souljam.mock.entity.CodeTypeEntity

interface CodeTypeRepository : JpaRepository<CodeTypeEntity, String>