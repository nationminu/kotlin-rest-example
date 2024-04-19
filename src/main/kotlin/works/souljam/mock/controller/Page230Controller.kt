package works.souljam.mock.controller

import works.souljam.mock.entity.Page230Entity
import works.souljam.mock.service.Page230Service
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/page230")
class Page230Controller(private val service: Page230Service) {

    @GetMapping
    fun getAllResults(): Map<String, Any>
            = service.getAllResults()

    @GetMapping("/all")
    fun getAllItems(): List<Page230Entity>
            = service.getAllItems()

    @GetMapping("/{id}")
    fun getItemById(@PathVariable id: String): Page230Entity
            = service.getItemById(id)

    @PostMapping
    fun createItem(@RequestBody page230Entity: Page230Entity): Page230Entity
            = service.createItem(page230Entity)

    @PostMapping("/all")
    fun createItems(@RequestBody page230Entities: List<Page230Entity>): List<Page230Entity> {
        return service.createItems(page230Entities)
    }

    @PutMapping("/{id}")
    fun updateItem(@PathVariable id: String, @RequestBody updatedPage230Entity: Page230Entity): Page230Entity =
        service.updateItem(id, updatedPage230Entity)

    @DeleteMapping("/{id}")
    fun deleteItem(@PathVariable id: String) {
        service.deleteItem(id)
    }
}
