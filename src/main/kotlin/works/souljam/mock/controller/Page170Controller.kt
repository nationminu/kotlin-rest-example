package works.souljam.mock.controller

import works.souljam.mock.entity.Page170Entity
import works.souljam.mock.service.Page170Service
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/page170")
class Page170Controller(private val service: Page170Service) {

    @GetMapping
    fun getAllResults(): Map<String, Any>
            = service.getAllResults()

    @GetMapping("/all")
    fun getAllItems(): List<Page170Entity>
            = service.getAllItems()

    @GetMapping("/{id}")
    fun getItemById(@PathVariable id: String): Page170Entity
            = service.getItemById(id)

    @PostMapping
    fun createItem(@RequestBody page170Entity: Page170Entity): Page170Entity
            = service.createItem(page170Entity)

    @PostMapping("/all")
    fun createItems(@RequestBody page170Entities: List<Page170Entity>): List<Page170Entity> {
        return service.createItems(page170Entities)
    }

    @PutMapping("/{id}")
    fun updateItem(@PathVariable id: String, @RequestBody updatedPage170Entity: Page170Entity): Page170Entity =
        service.updateItem(id, updatedPage170Entity)

    @DeleteMapping("/{id}")
    fun deleteItem(@PathVariable id: String) {
        service.deleteItem(id)
    }
}
