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
@Entity(name = "tab_page180")
class Page180Entity : BaseEntity() {

    val businessPlace: String? = null
    val code: String? = null
    val status: String? = null
    val type: String? = null
    val workplaceCode: String? = null
    val workplaceName: String? = null
    val cavity: String? = null
    val purchaseDate: String? = null
    val purchasePrice: String? = null
    val manufacturer: String? = null
    val manufacturerContact: String? = null
    val serialNumber: String? = null
    val manufactureDate: String? = null
    val modelInfo: String? = null
    val standardInfo: String? = null
    val coreComponentInfo: String? = null
    val installationPlace: String? = null
    val facilitiesManager: String? = null
    val facilitiesManagerSub: String? = null
    val installationInspection: String? = null
    val performanceTotal: String? = null
    val image: String? = null
}