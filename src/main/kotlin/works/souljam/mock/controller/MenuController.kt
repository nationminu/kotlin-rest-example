package works.souljam.mock.controller

import works.souljam.mock.entity.MenuEntity
import org.springframework.web.bind.annotation.*
import works.souljam.mock.service.MenuService

@RestController
@RequestMapping("/api/menus")
class MenuController(private val service: MenuService) {

    @GetMapping
    fun getAllResults(): Map<String, Any>
            = service.getAllResults()

    @GetMapping("/all")
    fun getAllItems(): List<MenuEntity>
            = service.getAllItems()

    @GetMapping("/hierarchical")
    fun getHierarchicalItems(): Map<String, Any>
            = service.getHierarchicalItems()

    @GetMapping("/{id}")
    fun getItemById(@PathVariable id: String): MenuEntity
            = service.getItemById(id)

    @PostMapping
    fun createItem(@RequestBody menuEntity: MenuEntity): MenuEntity
            = service.createItem(menuEntity)

    @PostMapping("/all")
    fun createItems(@RequestBody productEntities: List<MenuEntity>): List<MenuEntity> {
        return service.createItems(productEntities)
    }

    @PutMapping("/{id}")
    fun updateItem(@PathVariable id: String, @RequestBody updatedMenuEntity: MenuEntity): MenuEntity =
        service.updateItem(id, updatedMenuEntity)

    @DeleteMapping("/{id}")
    fun deleteItem(@PathVariable id: String) {
        service.deleteItem(id)
    }
}