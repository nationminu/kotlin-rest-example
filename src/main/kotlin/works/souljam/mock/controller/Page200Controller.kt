package works.souljam.mock.controller

import works.souljam.mock.entity.Page200Entity
import works.souljam.mock.service.Page200Service
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/page200")
class Page200Controller(private val service: Page200Service) {

    @GetMapping
    fun getAllResults(): Map<String, Any>
            = service.getAllResults()

    @GetMapping("/all")
    fun getAllItems(): List<Page200Entity>
            = service.getAllItems()

    @GetMapping("/{id}")
    fun getItemById(@PathVariable id: String): Page200Entity
            = service.getItemById(id)

    @PostMapping
    fun createItem(@RequestBody page200Entity: Page200Entity): Page200Entity
            = service.createItem(page200Entity)

    @PostMapping("/all")
    fun createItems(@RequestBody page200Entities: List<Page200Entity>): List<Page200Entity> {
        return service.createItems(page200Entities)
    }

    @PutMapping("/{id}")
    fun updateItem(@PathVariable id: String, @RequestBody updatedPage200Entity: Page200Entity): Page200Entity =
        service.updateItem(id, updatedPage200Entity)

    @DeleteMapping("/{id}")
    fun deleteItem(@PathVariable id: String) {
        service.deleteItem(id)
    }
}
