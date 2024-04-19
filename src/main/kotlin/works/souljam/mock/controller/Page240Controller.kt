package works.souljam.mock.controller

import works.souljam.mock.entity.Page240Entity
import works.souljam.mock.service.Page240Service
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/page240")
class Page240Controller(private val service: Page240Service) {

    @GetMapping
    fun getAllResults(): Map<String, Any>
            = service.getAllResults()

    @GetMapping("/all")
    fun getAllItems(): List<Page240Entity>
            = service.getAllItems()

    @GetMapping("/{id}")
    fun getItemById(@PathVariable id: String): Page240Entity
            = service.getItemById(id)

    @PostMapping
    fun createItem(@RequestBody page240Entity: Page240Entity): Page240Entity
            = service.createItem(page240Entity)

    @PostMapping("/all")
    fun createItems(@RequestBody page240Entities: List<Page240Entity>): List<Page240Entity> {
        return service.createItems(page240Entities)
    }

    @PutMapping("/{id}")
    fun updateItem(@PathVariable id: String, @RequestBody updatedPage240Entity: Page240Entity): Page240Entity =
        service.updateItem(id, updatedPage240Entity)

    @DeleteMapping("/{id}")
    fun deleteItem(@PathVariable id: String) {
        service.deleteItem(id)
    }
}
