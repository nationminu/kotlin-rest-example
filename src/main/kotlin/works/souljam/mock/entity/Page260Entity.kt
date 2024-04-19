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
@Entity(name = "tab_page260")
class Page260Entity : BaseEntity() {

    val category: String? = null
    val itemName: String? = null
    val status: String? = null
    val stock: String? = null
    val price: String? = null
    val cost: String? = null
    val totalSales: String? = null
    val totalCost: String? = null
    val totalProfit: String? = null
}