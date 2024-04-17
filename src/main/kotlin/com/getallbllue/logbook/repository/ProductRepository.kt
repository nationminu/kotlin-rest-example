package com.getallbllue.logbook.repository

import com.getallbllue.logbook.entity.ProductEntity
import org.springframework.data.jpa.repository.JpaRepository

interface ProductRepository : JpaRepository<ProductEntity, String>