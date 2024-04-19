package works.souljam.mock.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*
import lombok.*
import lombok.experimental.SuperBuilder
import org.hibernate.annotations.Where


@SuperBuilder
@Getter
@Setter
@ToString(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "tab_code_type")
class CodeTypeEntity : BaseEntity() {

    @Builder.Default
    @OneToMany(mappedBy = "codeTypeEntity", targetEntity = CodeEntity::class, fetch = FetchType.LAZY)
    @Where(clause = "used = true")
    @OrderBy("order_by asc")
    val codeEntities: Set<CodeEntity> = HashSet()
}