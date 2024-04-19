package works.souljam.mock.controller

import works.souljam.mock.entity.Page220Entity
import works.souljam.mock.service.Page220Service
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/page220")
class Page220Controller(private val service: Page220Service) {

    @GetMapping
    fun getAllResults(): Map<String, Any>
            = service.getAllResults()

    @GetMapping("/all")
    fun getAllItems(): List<Page220Entity>
            = service.getAllItems()

    @GetMapping("/{id}")
    fun getItemById(@PathVariable id: String): Page220Entity
            = service.getItemById(id)

    @PostMapping
    fun createItem(@RequestBody page220Entity: Page220Entity): Page220Entity
            = service.createItem(page220Entity)

    @PostMapping("/all")
    fun createItems(@RequestBody page220Entities: List<Page220Entity>): List<Page220Entity> {
        return service.createItems(page220Entities)
    }

    @PutMapping("/{id}")
    fun updateItem(@PathVariable id: String, @RequestBody updatedPage220Entity: Page220Entity): Page220Entity =
        service.updateItem(id, updatedPage220Entity)

    @DeleteMapping("/{id}")
    fun deleteItem(@PathVariable id: String) {
        service.deleteItem(id)
    }
}
