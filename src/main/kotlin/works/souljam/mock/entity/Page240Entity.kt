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
@Entity(name = "tab_page240")
class Page240Entity : BaseEntity() {

    var businessPlace: String? = null
    var workplaceCode: String? = null
    var workplaceName: String? = null
    var facilityCode: String? = null
    var facilityName: String? = null
    var inspectionName: String? = null
    var inspectionType: String? = null
    var type: String? = null
    var unit: String? = null
    var standardValue: String? = null
    var standardLowerLimit: String? = null
    var standardMaximum: String? = null
    var image: String? = null
}