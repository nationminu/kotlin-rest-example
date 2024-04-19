package works.souljam.mock.controller

import works.souljam.mock.entity.Page140Entity
import works.souljam.mock.service.Page140Service
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/page140")
class Page140Controller(private val service: Page140Service) {

    @GetMapping
    fun getAllResults(): Map<String, Any>
            = service.getAllResults()

    @GetMapping("/all")
    fun getAllItems(): List<Page140Entity>
            = service.getAllItems()

    @GetMapping("/{id}")
    fun getItemById(@PathVariable id: String): Page140Entity
            = service.getItemById(id)

    @PostMapping
    fun createItem(@RequestBody page140Entity: Page140Entity): Page140Entity
            = service.createItem(page140Entity)

    @PostMapping("/all")
    fun createItems(@RequestBody page140Entities: List<Page140Entity>): List<Page140Entity> {
        return service.createItems(page140Entities)
    }

    @PutMapping("/{id}")
    fun updateItem(@PathVariable id: String, @RequestBody updatedPage140Entity: Page140Entity): Page140Entity =
        service.updateItem(id, updatedPage140Entity)

    @DeleteMapping("/{id}")
    fun deleteItem(@PathVariable id: String) {
        service.deleteItem(id)
    }
}
