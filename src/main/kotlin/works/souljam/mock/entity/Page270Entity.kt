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
@Entity(name = "tab_page270")
class Page270Entity : BaseEntity() {

    val businessPlace: String? = null
    val code: String? = null
    val type: String? = null
    val cavity: String? = null
    val manufacturer: String? = null
    val manufacturerContact: String? = null
    val modelInfo: String? = null
    val standardInfo: String? = null
    val lifeBats: String? = null
    val safetyStock: String? = null
    val manager: String? = null
    val managerSub: String? = null
    val inspectionBats: String? = null
    val inspectionCycle: String? = null
    val image: String? = null
}