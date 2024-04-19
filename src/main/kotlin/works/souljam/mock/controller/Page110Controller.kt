package works.souljam.mock.controller

import works.souljam.mock.entity.Page110Entity
import works.souljam.mock.service.Page110Service
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/page110")
class Page110Controller(private val service: Page110Service) {

    @GetMapping
    fun getAllResults(): Map<String, Any>
            = service.getAllResults()

    @GetMapping("/all")
    fun getAllItems(): List<Page110Entity>
            = service.getAllItems()

    @GetMapping("/{id}")
    fun getItemById(@PathVariable id: String): Page110Entity
            = service.getItemById(id)

    @PostMapping
    fun createItem(@RequestBody page110Entity: Page110Entity): Page110Entity
            = service.createItem(page110Entity)

    @PostMapping("/all")
    fun createItems(@RequestBody page110Entities: List<Page110Entity>): List<Page110Entity> {
        return service.createItems(page110Entities)
    }

    @PutMapping("/{id}")
    fun updateItem(@PathVariable id: String, @RequestBody updatedPage110Entity: Page110Entity): Page110Entity =
        service.updateItem(id, updatedPage110Entity)

    @DeleteMapping("/{id}")
    fun deleteItem(@PathVariable id: String) {
        service.deleteItem(id)
    }
}
