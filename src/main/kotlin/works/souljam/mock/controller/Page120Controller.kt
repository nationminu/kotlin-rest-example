package works.souljam.mock.controller

import works.souljam.mock.entity.Page120Entity
import works.souljam.mock.service.Page120Service
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/page120")
class Page120Controller(private val service: Page120Service) {

    @GetMapping
    fun getAllResults(): Map<String, Any>
            = service.getAllResults()

    @GetMapping("/all")
    fun getAllItems(): List<Page120Entity>
            = service.getAllItems()

    @GetMapping("/{id}")
    fun getItemById(@PathVariable id: String): Page120Entity
            = service.getItemById(id)

    @PostMapping
    fun createItem(@RequestBody page120Entity: Page120Entity): Page120Entity
            = service.createItem(page120Entity)

    @PostMapping("/all")
    fun createItems(@RequestBody page120Entities: List<Page120Entity>): List<Page120Entity> {
        return service.createItems(page120Entities)
    }

    @PutMapping("/{id}")
    fun updateItem(@PathVariable id: String, @RequestBody updatedPage120Entity: Page120Entity): Page120Entity =
        service.updateItem(id, updatedPage120Entity)

    @DeleteMapping("/{id}")
    fun deleteItem(@PathVariable id: String) {
        service.deleteItem(id)
    }
}
