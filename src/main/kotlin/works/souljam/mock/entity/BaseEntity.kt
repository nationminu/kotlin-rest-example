package works.souljam.mock.entity

import jakarta.persistence.*
import lombok.*
import lombok.experimental.SuperBuilder
import org.hibernate.annotations.ColumnDefault
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.io.Serializable
import java.time.LocalDateTime
import java.util.*

@SuperBuilder
@Getter
@Setter
@ToString(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
open abstract class BaseEntity : Serializable {

    @Id
    @Column(length = 36)
    var id: String? = null

    val name: String? = null
    val description: String? = null

    @Column(name = "used", nullable = false)
    @ColumnDefault("true")
    @Builder.Default
    var isUsed: Boolean = true

    @Column(name = "order_by", nullable = false)
    @ColumnDefault("1")
    @Builder.Default
    var orderBy: Int = 1

    //@CreationTimestamp
    var createdAt: LocalDateTime? = null
    var createdBy: String? = null

    @UpdateTimestamp
    var updatedAt: LocalDateTime? = null
    var updatedBy: String? = null

    @PrePersist
    protected fun prePersist() {
        if (id == null) id = UUID.randomUUID().toString()
        if (createdAt == null) createdAt = LocalDateTime.now()
    }
}