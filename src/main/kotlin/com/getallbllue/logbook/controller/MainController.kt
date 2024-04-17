package com.getallbllue.logbook.controller

import com.getallbllue.logbook.entity.ProductEntity
import com.getallbllue.logbook.service.ProductService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/products")
class MainController(private val productService: ProductService) {

    @GetMapping
    fun getAllResults(): Map<String, Any>
            = productService.getAllResults()

    @GetMapping("/all")
    fun getAllProducts(): List<ProductEntity>
            = productService.getAllProducts()

    @GetMapping("/{id}")
    fun getProductById(@PathVariable id: String): ProductEntity
            = productService.getProductById(id)

    @PostMapping
    fun createProduct(@RequestBody productEntity: ProductEntity): ProductEntity
            = productService.createProduct(productEntity)

    @PostMapping("/all")
    fun createProducts(@RequestBody productEntities: List<ProductEntity>): List<ProductEntity> {
        return productService.createProducts(productEntities)
    }

    @PutMapping("/{id}")
    fun updateProduct(@PathVariable id: String, @RequestBody updatedProductEntity: ProductEntity): ProductEntity =
        productService.updateProduct(id, updatedProductEntity)

    @DeleteMapping("/{id}")
    fun deleteProduct(@PathVariable id: String) {
        productService.deleteProduct(id)
    }
}