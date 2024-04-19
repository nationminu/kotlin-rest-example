package works.souljam.mock.controller

import works.souljam.mock.entity.Page210Entity
import works.souljam.mock.service.Page210Service
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/page210")
class Page210Controller(private val service: Page210Service) {

    @GetMapping
    fun getAllResults(): Map<String, Any>
            = service.getAllResults()

    @GetMapping("/all")
    fun getAllItems(): List<Page210Entity>
            = service.getAllItems()

    @GetMapping("/{id}")
    fun getItemById(@PathVariable id: String): Page210Entity
            = service.getItemById(id)

    @PostMapping
    fun createItem(@RequestBody page210Entity: Page210Entity): Page210Entity
            = service.createItem(page210Entity)

    @PostMapping("/all")
    fun createItems(@RequestBody page210Entities: List<Page210Entity>): List<Page210Entity> {
        return service.createItems(page210Entities)
    }

    @PutMapping("/{id}")
    fun updateItem(@PathVariable id: String, @RequestBody updatedPage210Entity: Page210Entity): Page210Entity =
        service.updateItem(id, updatedPage210Entity)

    @DeleteMapping("/{id}")
    fun deleteItem(@PathVariable id: String) {
        service.deleteItem(id)
    }
}
