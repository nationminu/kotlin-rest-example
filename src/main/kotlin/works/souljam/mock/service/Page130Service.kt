package works.souljam.mock.service

import works.souljam.mock.entity.Page130Entity
import works.souljam.mock.repository.Page130Repository

import org.springframework.stereotype.Service

@Service
class Page130Service(private val page130Repository: Page130Repository) {

    fun getAllItems(): List<Page130Entity>
            = page130Repository.findAll()

    fun getAllResults(): Map<String, Any> {
        var results = page130Repository.findAll()
        return mapOf("success" to true, "data" to results)
    }

    fun getItemById(id: String): Page130Entity = page130Repository.findById(id)
        .orElseThrow { NoSuchElementException("Product with id $id not found") }

    fun createItem(productEntity: Page130Entity): Page130Entity
            = page130Repository.save(productEntity)

    fun createItems(productEntities: List<Page130Entity>): List<Page130Entity> {
        val entities = productEntities.map { Page130Entity() }

        return page130Repository.saveAll(productEntities)
    }

    fun updateItem(id: String, updatedPage130Entity: Page130Entity): Page130Entity {
        if (!page130Repository.existsById(id)) {
            throw NoSuchElementException("Product with id $id not found")
        }
        updatedPage130Entity.id = id
        return page130Repository.save(updatedPage130Entity)
    }

    fun deleteItem(id: String) {
        if (!page130Repository.existsById(id)) {
            throw NoSuchElementException("Product with id $id not found")
        }
        page130Repository.deleteById(id)
    }
}