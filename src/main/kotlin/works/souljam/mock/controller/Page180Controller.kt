package works.souljam.mock.controller

import works.souljam.mock.entity.Page180Entity
import works.souljam.mock.service.Page180Service
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/page180")
class Page180Controller(private val service: Page180Service) {

    @GetMapping
    fun getAllResults(): Map<String, Any>
            = service.getAllResults()

    @GetMapping("/all")
    fun getAllItems(): List<Page180Entity>
            = service.getAllItems()

    @GetMapping("/{id}")
    fun getItemById(@PathVariable id: String): Page180Entity
            = service.getItemById(id)

    @PostMapping
    fun createItem(@RequestBody page180Entity: Page180Entity): Page180Entity
            = service.createItem(page180Entity)

    @PostMapping("/all")
    fun createItems(@RequestBody page180Entities: List<Page180Entity>): List<Page180Entity> {
        return service.createItems(page180Entities)
    }

    @PutMapping("/{id}")
    fun updateItem(@PathVariable id: String, @RequestBody updatedPage180Entity: Page180Entity): Page180Entity =
        service.updateItem(id, updatedPage180Entity)

    @DeleteMapping("/{id}")
    fun deleteItem(@PathVariable id: String) {
        service.deleteItem(id)
    }
}
