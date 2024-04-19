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
@Entity(name = "tab_page190")
class Page190Entity : BaseEntity() {

    val businessPlace: String? = null
    val code: String? = null
    val codeType: String? = null
}