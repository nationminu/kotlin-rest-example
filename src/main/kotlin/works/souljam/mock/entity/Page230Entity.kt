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
@Entity(name = "tab_page230")
class Page230Entity : BaseEntity() {

    var businessPlace: String? = null
    var manufacturer: String? = null
    var type: String? = null
    var modelCode: String? = null
    var modelName: String? = null
    var fileType: String? = null
    var separatorName: String? = null
    var standardFile: String? = null
    var multiplePerformance: String? = null
    var measurementHeaderRow: String? = null
    var collectionStartRow: String? = null
    var collectionEndSepartor: String? = null
    var measurementNameRowExistence: String? = null
    var measurementNameStartRow: String? = null
    var measurementNameEndColumn: String? = null
    var measurementNameHeaderExistence: String? = null
    var collectionStartColumn: String? = null
    var collectionEndColumn: String? = null
    var isStandardValue: String? = null
    var standardValueColumn: String? = null
    var lowerLimitValueExistence: String? = null
    var lowerLimitExistence: String? = null
    var lowerLimitValueColumn: String? = null
    var maximumValueExistence: String? = null
    var maximumExistence: String? = null
    var maximumValueColumn: String? = null
}