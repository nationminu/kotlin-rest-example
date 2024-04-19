package works.souljam.mock.controller

import works.souljam.mock.entity.CodeEntity
import works.souljam.mock.service.CodeService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/codes")
class CodeController(private val codeService: CodeService) {

    @GetMapping
    fun getAllResults(): Map<String, Any>
            = codeService.getAllResults()

    @GetMapping("/all")
    fun getAllItems(): List<CodeEntity>
            = codeService.getAllItems()

    @GetMapping("/{id}")
    fun getItemById(@PathVariable id: String): CodeEntity
            = codeService.getItemById(id)

    @PostMapping
    fun createItem(@RequestBody codeEntity: CodeEntity): CodeEntity
            = codeService.createItem(codeEntity)

    @PostMapping("/all")
    fun createItems(@RequestBody productEntities: List<CodeEntity>): List<CodeEntity> {
        return codeService.createItems(productEntities)
    }

    @PutMapping("/{id}")
    fun updateItem(@PathVariable id: String, @RequestBody updatedCodeEntity: CodeEntity): CodeEntity =
        codeService.updateItem(id, updatedCodeEntity)

    @DeleteMapping("/{id}")
    fun deleteItem(@PathVariable id: String) {
        codeService.deleteItem(id)
    }
}