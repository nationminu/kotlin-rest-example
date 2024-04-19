package works.souljam.mock.controller

import works.souljam.mock.entity.CodeTypeEntity
import works.souljam.mock.service.CodeTypeService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/code-types")
class CodeTypeController(private val codeTypeService: CodeTypeService) {

    @GetMapping
    fun getAllResults(): Map<String, Any>
            = codeTypeService.getAllResults()

    @GetMapping("/all")
    fun getAllItems(): List<CodeTypeEntity>
            = codeTypeService.getAllItems()

    @GetMapping("/{id}")
    fun getItemById(@PathVariable id: String): CodeTypeEntity
            = codeTypeService.getItemById(id)

    @PostMapping
    fun createItem(@RequestBody codeTypeEntity: CodeTypeEntity): CodeTypeEntity
            = codeTypeService.createItem(codeTypeEntity)

    @PostMapping("/all")
    fun createItems(@RequestBody productEntities: List<CodeTypeEntity>): List<CodeTypeEntity> {
        return codeTypeService.createItems(productEntities)
    }

    @PutMapping("/{id}")
    fun updateItem(@PathVariable id: String, @RequestBody updatedCodeTypeEntity: CodeTypeEntity): CodeTypeEntity =
        codeTypeService.updateItem(id, updatedCodeTypeEntity)

    @DeleteMapping("/{id}")
    fun deleteItem(@PathVariable id: String) {
        codeTypeService.deleteItem(id)
    }
}