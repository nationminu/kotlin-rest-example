package works.souljam.mock.controller

import works.souljam.mock.entity.Page160Entity
import works.souljam.mock.service.Page160Service
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/page160")
class Page160Controller(private val service: Page160Service) {

    @GetMapping
    fun getAllResults(): Map<String, Any>
            = service.getAllResults()

    @GetMapping("/all")
    fun getAllItems(): List<Page160Entity>
            = service.getAllItems()

    @GetMapping("/{id}")
    fun getItemById(@PathVariable id: String): Page160Entity
            = service.getItemById(id)

    @PostMapping
    fun createItem(@RequestBody page160Entity: Page160Entity): Page160Entity
            = service.createItem(page160Entity)

    @PostMapping("/all")
    fun createItems(@RequestBody page160Entities: List<Page160Entity>): List<Page160Entity> {
        return service.createItems(page160Entities)
    }

    @PutMapping("/{id}")
    fun updateItem(@PathVariable id: String, @RequestBody updatedPage160Entity: Page160Entity): Page160Entity =
        service.updateItem(id, updatedPage160Entity)

    @DeleteMapping("/{id}")
    fun deleteItem(@PathVariable id: String) {
        service.deleteItem(id)
    }
}
