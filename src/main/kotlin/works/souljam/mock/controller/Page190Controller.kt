package works.souljam.mock.controller

import works.souljam.mock.entity.Page190Entity
import works.souljam.mock.service.Page190Service
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/page190")
class Page190Controller(private val service: Page190Service) {

    @GetMapping
    fun getAllResults(): Map<String, Any>
            = service.getAllResults()

    @GetMapping("/all")
    fun getAllItems(): List<Page190Entity>
            = service.getAllItems()

    @GetMapping("/{id}")
    fun getItemById(@PathVariable id: String): Page190Entity
            = service.getItemById(id)

    @PostMapping
    fun createItem(@RequestBody page190Entity: Page190Entity): Page190Entity
            = service.createItem(page190Entity)

    @PostMapping("/all")
    fun createItems(@RequestBody page190Entities: List<Page190Entity>): List<Page190Entity> {
        return service.createItems(page190Entities)
    }

    @PutMapping("/{id}")
    fun updateItem(@PathVariable id: String, @RequestBody updatedPage190Entity: Page190Entity): Page190Entity =
        service.updateItem(id, updatedPage190Entity)

    @DeleteMapping("/{id}")
    fun deleteItem(@PathVariable id: String) {
        service.deleteItem(id)
    }
}
