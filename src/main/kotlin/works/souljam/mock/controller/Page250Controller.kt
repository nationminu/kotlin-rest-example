package works.souljam.mock.controller

import works.souljam.mock.entity.Page250Entity
import works.souljam.mock.service.Page250Service
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/page250")
class Page250Controller(private val service: Page250Service) {

    @GetMapping
    fun getAllResults(): Map<String, Any>
            = service.getAllResults()

    @GetMapping("/all")
    fun getAllItems(): List<Page250Entity>
            = service.getAllItems()

    @GetMapping("/{id}")
    fun getItemById(@PathVariable id: String): Page250Entity
            = service.getItemById(id)

    @PostMapping
    fun createItem(@RequestBody page250Entity: Page250Entity): Page250Entity
            = service.createItem(page250Entity)

    @PostMapping("/all")
    fun createItems(@RequestBody page250Entities: List<Page250Entity>): List<Page250Entity> {
        return service.createItems(page250Entities)
    }

    @PutMapping("/{id}")
    fun updateItem(@PathVariable id: String, @RequestBody updatedPage250Entity: Page250Entity): Page250Entity =
        service.updateItem(id, updatedPage250Entity)

    @DeleteMapping("/{id}")
    fun deleteItem(@PathVariable id: String) {
        service.deleteItem(id)
    }
}
