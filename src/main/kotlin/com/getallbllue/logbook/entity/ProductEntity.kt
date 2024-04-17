package com.getallbllue.logbook.entity

import jakarta.persistence.Entity
import jakarta.persistence.MappedSuperclass
import jakarta.persistence.Table

@Entity
@Table(name = "tab_product")
class ProductEntity : BaseEntity() {
    val name: String? = null
    val description: String? = null
    val price: Double? = null
}