package works.souljam.mock.repository

import works.souljam.mock.entity.ProductEntity
import org.springframework.data.jpa.repository.JpaRepository

interface ProductRepository : JpaRepository<ProductEntity, String>