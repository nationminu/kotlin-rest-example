package works.souljam.mock.controller

import works.souljam.mock.entity.Page150Entity
import works.souljam.mock.service.Page150Service
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/page150")
class Page150Controller(private val service: Page150Service) {

    @GetMapping
    fun getAllResults(): Map<String, Any>
            = service.getAllResults()

    @GetMapping("/all")
    fun getAllItems(): List<Page150Entity>
            = service.getAllItems()

    @GetMapping("/{id}")
    fun getItemById(@PathVariable id: String): Page150Entity
            = service.getItemById(id)

    @PostMapping
    fun createItem(@RequestBody page150Entity: Page150Entity): Page150Entity
            = service.createItem(page150Entity)

    @PostMapping("/all")
    fun createItems(@RequestBody page150Entities: List<Page150Entity>): List<Page150Entity> {
        return service.createItems(page150Entities)
    }

    @PutMapping("/{id}")
    fun updateItem(@PathVariable id: String, @RequestBody updatedPage150Entity: Page150Entity): Page150Entity =
        service.updateItem(id, updatedPage150Entity)

    @DeleteMapping("/{id}")
    fun deleteItem(@PathVariable id: String) {
        service.deleteItem(id)
    }
}
