package works.souljam.mock.controller

import works.souljam.mock.entity.Page130Entity
import works.souljam.mock.service.Page130Service
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/page130")
class Page130Controller(private val service: Page130Service) {

    @GetMapping
    fun getAllResults(): Map<String, Any>
            = service.getAllResults()

    @GetMapping("/all")
    fun getAllItems(): List<Page130Entity>
            = service.getAllItems()

    @GetMapping("/{id}")
    fun getItemById(@PathVariable id: String): Page130Entity
            = service.getItemById(id)

    @PostMapping
    fun createItem(@RequestBody page130Entity: Page130Entity): Page130Entity
            = service.createItem(page130Entity)

    @PostMapping("/all")
    fun createItems(@RequestBody page130Entities: List<Page130Entity>): List<Page130Entity> {
        return service.createItems(page130Entities)
    }

    @PutMapping("/{id}")
    fun updateItem(@PathVariable id: String, @RequestBody updatedPage130Entity: Page130Entity): Page130Entity =
        service.updateItem(id, updatedPage130Entity)

    @DeleteMapping("/{id}")
    fun deleteItem(@PathVariable id: String) {
        service.deleteItem(id)
    }
}
