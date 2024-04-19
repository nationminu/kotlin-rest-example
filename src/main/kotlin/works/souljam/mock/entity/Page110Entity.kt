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
@Entity(name = "tab_page110")
class Page110Entity : BaseEntity() {

    val businessPlace: String? = null
    val type: String? = null
    val groupName: String? = null
    val spec: String? = null
    val texture: String? = null
    val model: String? = null
    val unit: String? = null
    val importInspection: String? = null
    val monitoring: String? = null
}