package works.souljam.mock.controller

import works.souljam.mock.entity.Page100Entity
import works.souljam.mock.service.Page100Service
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/page100")
class Page100Controller(private val service: Page100Service) {

    @GetMapping
    fun getAllResults(): Map<String, Any>
            = service.getAllResults()

    @GetMapping("/all")
    fun getAllItems(): List<Page100Entity>
            = service.getAllItems()

    @GetMapping("/{id}")
    fun getItemById(@PathVariable id: String): Page100Entity
            = service.getItemById(id)

    @PostMapping
    fun createItem(@RequestBody page100Entity: Page100Entity): Page100Entity
            = service.createItem(page100Entity)

    @PostMapping("/all")
    fun createItems(@RequestBody page100Entities: List<Page100Entity>): List<Page100Entity> {
        return service.createItems(page100Entities)
    }

    @PutMapping("/{id}")
    fun updateItem(@PathVariable id: String, @RequestBody updatedPage100Entity: Page100Entity): Page100Entity =
        service.updateItem(id, updatedPage100Entity)

    @DeleteMapping("/{id}")
    fun deleteItem(@PathVariable id: String) {
        service.deleteItem(id)
    }
}
