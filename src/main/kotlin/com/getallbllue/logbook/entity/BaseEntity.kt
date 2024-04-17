package com.getallbllue.logbook.entity

import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.io.Serializable
import java.time.LocalDateTime
import java.util.*

@MappedSuperclass
open abstract class BaseEntity : Serializable {

    @Id
    @Column(length = 36)
    var id: String? = null

    @CreationTimestamp
    var createdAt: LocalDateTime? = null
    var createdBy: String? = null

    @UpdateTimestamp
    var updatedAt: LocalDateTime? = null
    var updatedBy: String? = null

    @PrePersist
    protected fun prePersist() {
        if (id == null) id = UUID.randomUUID().toString()
    }
}