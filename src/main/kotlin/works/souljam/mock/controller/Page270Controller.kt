package works.souljam.mock.controller

import works.souljam.mock.entity.Page270Entity
import works.souljam.mock.service.Page270Service
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/page270")
class Page270Controller(private val service: Page270Service) {

    @GetMapping
    fun getAllResults(): Map<String, Any>
            = service.getAllResults()

    @GetMapping("/all")
    fun getAllItems(): List<Page270Entity>
            = service.getAllItems()

    @GetMapping("/{id}")
    fun getItemById(@PathVariable id: String): Page270Entity
            = service.getItemById(id)

    @PostMapping
    fun createItem(@RequestBody page270Entity: Page270Entity): Page270Entity
            = service.createItem(page270Entity)

    @PostMapping("/all")
    fun createItems(@RequestBody page270Entities: List<Page270Entity>): List<Page270Entity> {
        return service.createItems(page270Entities)
    }

    @PutMapping("/{id}")
    fun updateItem(@PathVariable id: String, @RequestBody updatedPage270Entity: Page270Entity): Page270Entity =
        service.updateItem(id, updatedPage270Entity)

    @DeleteMapping("/{id}")
    fun deleteItem(@PathVariable id: String) {
        service.deleteItem(id)
    }
}
