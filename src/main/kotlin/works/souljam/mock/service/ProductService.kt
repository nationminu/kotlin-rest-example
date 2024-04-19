package works.souljam.mock.service

import works.souljam.mock.entity.ProductEntity
import works.souljam.mock.repository.ProductRepository

import org.springframework.stereotype.Service

@Service
class ProductService(private val productRepository: ProductRepository) {

    fun getAllItems(): List<ProductEntity>
            = productRepository.findAll()

    fun getAllResults(): Map<String, Any> {
        var results = productRepository.findAll()
        return mapOf("success" to true, "data" to results)
    }

    fun getItemById(id: String): ProductEntity = productRepository.findById(id)
        .orElseThrow { NoSuchElementException("Product with id $id not found") }

    fun createItem(productEntity: ProductEntity): ProductEntity
            = productRepository.save(productEntity)

    fun createItems(productEntities: List<ProductEntity>): List<ProductEntity> {
        val entities = productEntities.map { ProductEntity() }

        return productRepository.saveAll(productEntities)
    }

    fun updateItem(id: String, updatedProductEntity: ProductEntity): ProductEntity {
        if (!productRepository.existsById(id)) {
            throw NoSuchElementException("Product with id $id not found")
        }
        updatedProductEntity.id = id
        return productRepository.save(updatedProductEntity)
    }

    fun deleteItem(id: String) {
        if (!productRepository.existsById(id)) {
            throw NoSuchElementException("Product with id $id not found")
        }
        productRepository.deleteById(id)
    }
}