package works.souljam.mock.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*
import jakarta.validation.constraints.NotBlank
import lombok.*
import lombok.experimental.SuperBuilder

@SuperBuilder
@Getter
@Setter
@ToString(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "tab_menu")
class MenuEntity : BaseEntity() {

    var type: String? = null

    @Column(name = "parent_id", nullable = true)
    var parentId: String? = null
    var children: MutableList<MenuEntity>? = null
}