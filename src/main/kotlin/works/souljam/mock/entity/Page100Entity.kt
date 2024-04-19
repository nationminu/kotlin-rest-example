package works.souljam.mock.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import lombok.*
import lombok.experimental.SuperBuilder
import org.hibernate.annotations.ColumnDefault

@SuperBuilder
@Getter
@Setter
@ToString(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "tab_page100")
class Page100Entity : BaseEntity() {

    var type: String? = null
}