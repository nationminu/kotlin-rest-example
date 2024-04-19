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
@Entity(name = "tab_page140")
class Page140Entity : BaseEntity() {

    val businessPlace: String? = null
    val code: String? = null
    val type: String? = null
    val nameEn: String? = null
    val startedAt: String? = null
    val endedAt: String? = null
    val businessRegistrationNumber: String? = null
    val status: String? = null
    val category: String? = null
    val address: String? = null
    val zipCode: String? = null
    val numberPhone: String? = null
    val numberFax: String? = null
    val email: String? = null
    val ceo: String? = null
    val manager: String? = null
    val managerPosition: String? = null
    val managerNumber: String? = null
    val managerEmail: String? = null
    val businessPartnerBank: String? = null
    val businessPartnerNumberAccount: String? = null
    val businessPartnerAccountHolder: String? = null
}