package works.souljam.mock.entity

import jakarta.persistence.Entity
import lombok.*
import lombok.experimental.SuperBuilder

@SuperBuilder
@Getter
@Setter
@ToString(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "tab_product")
class ProductEntity : BaseEntity() {

    val stock: Double? = null
    val price: Double? = null
    val origin: String? = null
    val market: String? = null
    val expirationDate: String? = null
}