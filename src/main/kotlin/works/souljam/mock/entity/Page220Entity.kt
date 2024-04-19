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
@Entity(name = "tab_page220")
class Page220Entity : BaseEntity() {

    val businessPlace: String? = null
    var typeInspect: String? = null
    var codeProcess: String? = null
    var nameProcess: String? = null
    var nameInspect: String? = null
    var type: String? = null
    var unit: String? = null
    var inspectSample: String? = null
    var value: String? = null
    var standardLow: String? = null
    var standardHigh: String? = null
    var manageLow: String? = null
    var manageHigh: String? = null
    var boundaryLow: String? = null
    var boundaryHigh: String? = null
    var image: String? = null
}