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
@Entity(name = "tab_page150")
class Page150Entity : BaseEntity() {

    val businessPlace: String? = null
    val code: String? = null
    val showOnSite: String? = null
}