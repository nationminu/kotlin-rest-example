package works.souljam.mock.controller

import works.souljam.mock.entity.ProductEntity
import works.souljam.mock.service.ProductService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/products")
class ProductController(private val productService: ProductService) {

    @GetMapping
    fun getAllResults(): Map<String, Any>
            = productService.getAllResults()

    @GetMapping("/all")
    fun getAllItems(): List<ProductEntity>
            = productService.getAllItems()

    @GetMapping("/{id}")
    fun getItemById(@PathVariable id: String): ProductEntity
            = productService.getItemById(id)

    @PostMapping
    fun createItem(@RequestBody productEntity: ProductEntity): ProductEntity
            = productService.createItem(productEntity)

    @PostMapping("/all")
    fun createItems(@RequestBody productEntities: List<ProductEntity>): List<ProductEntity> {
        return productService.createItems(productEntities)
    }

    @PutMapping("/{id}")
    fun updateItem(@PathVariable id: String, @RequestBody updatedProductEntity: ProductEntity): ProductEntity =
        productService.updateItem(id, updatedProductEntity)

    @DeleteMapping("/{id}")
    fun deleteItem(@PathVariable id: String) {
        productService.deleteItem(id)
    }
}
