package works.souljam.mock.controller

import works.souljam.mock.entity.MenuEntity
import works.souljam.mock.service.MenuService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/menus")
class MenuController(private val menuService: MenuService) {

    @GetMapping
    fun getAllResults(): Map<String, Any>
            = menuService.getAllResults()

    @GetMapping("/all")
    fun getAllItems(): List<MenuEntity>
            = menuService.getAllItems()

    @GetMapping("/hierarchical")
    fun getHierarchicalItems(): List<MenuEntity>
            = menuService.getAllMenusHierarchical()

    @GetMapping("/{id}")
    fun getItemById(@PathVariable id: String): MenuEntity
            = menuService.getItemById(id)

    @PostMapping
    fun createItem(@RequestBody menuEntity: MenuEntity): MenuEntity
            = menuService.createItem(menuEntity)

    @PostMapping("/all")
    fun createItems(@RequestBody productEntities: List<MenuEntity>): List<MenuEntity> {
        return menuService.createItems(productEntities)
    }

    @PutMapping("/{id}")
    fun updateItem(@PathVariable id: String, @RequestBody updatedMenuEntity: MenuEntity): MenuEntity =
        menuService.updateItem(id, updatedMenuEntity)

    @DeleteMapping("/{id}")
    fun deleteItem(@PathVariable id: String) {
        menuService.deleteItem(id)
    }
}