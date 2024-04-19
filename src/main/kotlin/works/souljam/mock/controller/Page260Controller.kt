package works.souljam.mock.controller

import works.souljam.mock.entity.Page260Entity
import works.souljam.mock.service.Page260Service
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/page260")
class Page260Controller(private val service: Page260Service) {

    @GetMapping
    fun getAllResults(): Map<String, Any>
            = service.getAllResults()

    @GetMapping("/all")
    fun getAllItems(): List<Page260Entity>
            = service.getAllItems()

    @GetMapping("/{id}")
    fun getItemById(@PathVariable id: String): Page260Entity
            = service.getItemById(id)

    @PostMapping
    fun createItem(@RequestBody page260Entity: Page260Entity): Page260Entity
            = service.createItem(page260Entity)

    @PostMapping("/all")
    fun createItems(@RequestBody page260Entities: List<Page260Entity>): List<Page260Entity> {
        return service.createItems(page260Entities)
    }

    @PutMapping("/{id}")
    fun updateItem(@PathVariable id: String, @RequestBody updatedPage260Entity: Page260Entity): Page260Entity =
        service.updateItem(id, updatedPage260Entity)

    @DeleteMapping("/{id}")
    fun deleteItem(@PathVariable id: String) {
        service.deleteItem(id)
    }
}
