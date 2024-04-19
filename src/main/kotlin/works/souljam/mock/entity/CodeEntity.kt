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
@Entity(name = "TAB_CODE")
class CodeEntity : BaseEntity() {

    @NotBlank(message = "Code Type is mandatory")
    @Column(name = "code_type_id", nullable = false)
    var codeTypeId: String? = null

    @JsonIgnore
    @ToString.Exclude
    @ManyToOne(targetEntity = CodeTypeEntity::class, fetch = FetchType.LAZY)
    @JoinColumn(name = "code_type_id", nullable = false, insertable = false, updatable = false)
    val codeTypeEntity: CodeTypeEntity? = null
}
