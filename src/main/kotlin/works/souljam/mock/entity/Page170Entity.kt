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
@Entity(name = "tab_page170")
class Page170Entity : BaseEntity() {

    val businessPlace: String? = null
    val codeWorkplace: String? = null
    val nameWorkplace: String? = null
    val codeProcess: String? = null
    val nameProcess: String? = null
    val codeLine: String? = null
    val nameline: String? = null
    val showOnSite: String? = null
}