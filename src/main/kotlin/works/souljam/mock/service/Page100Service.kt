package works.souljam.mock.service

import works.souljam.mock.entity.Page100Entity
import works.souljam.mock.repository.Page100Repository

import org.springframework.stereotype.Service

@Service
class Page100Service(private val page100Repository: Page100Repository) {

    fun getAllItems(): List<Page100Entity>
            = page100Repository.findAll()

    fun getAllResults(): Map<String, Any> {
        var results = page100Repository.findAll()
        return mapOf("success" to true, "data" to results)
    }

    fun getItemById(id: String): Page100Entity = page100Repository.findById(id)
        .orElseThrow { NoSuchElementException("Product with id $id not found") }

    fun createItem(productEntity: Page100Entity): Page100Entity
            = page100Repository.save(productEntity)

    fun createItems(productEntities: List<Page100Entity>): List<Page100Entity> {
        val entities = productEntities.map { Page100Entity() }

        return page100Repository.saveAll(productEntities)
    }

    fun updateItem(id: String, updatedPage100Entity: Page100Entity): Page100Entity {
        if (!page100Repository.existsById(id)) {
            throw NoSuchElementException("Product with id $id not found")
        }
        updatedPage100Entity.id = id
        return page100Repository.save(updatedPage100Entity)
    }

    fun deleteItem(id: String) {
        if (!page100Repository.existsById(id)) {
            throw NoSuchElementException("Product with id $id not found")
        }
        page100Repository.deleteById(id)
    }
}