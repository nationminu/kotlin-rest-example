package works.souljam.mock.service

import works.souljam.mock.entity.Page180Entity
import works.souljam.mock.repository.Page180Repository

import org.springframework.stereotype.Service

@Service
class Page180Service(private val page180Repository: Page180Repository) {

    fun getAllItems(): List<Page180Entity>
            = page180Repository.findAll()

    fun getAllResults(): Map<String, Any> {
        var results = page180Repository.findAll()
        return mapOf("success" to true, "data" to results)
    }

    fun getItemById(id: String): Page180Entity = page180Repository.findById(id)
        .orElseThrow { NoSuchElementException("Product with id $id not found") }

    fun createItem(productEntity: Page180Entity): Page180Entity
            = page180Repository.save(productEntity)

    fun createItems(productEntities: List<Page180Entity>): List<Page180Entity> {
        val entities = productEntities.map { Page180Entity() }

        return page180Repository.saveAll(productEntities)
    }

    fun updateItem(id: String, updatedPage180Entity: Page180Entity): Page180Entity {
        if (!page180Repository.existsById(id)) {
            throw NoSuchElementException("Product with id $id not found")
        }
        updatedPage180Entity.id = id
        return page180Repository.save(updatedPage180Entity)
    }

    fun deleteItem(id: String) {
        if (!page180Repository.existsById(id)) {
            throw NoSuchElementException("Product with id $id not found")
        }
        page180Repository.deleteById(id)
    }
}