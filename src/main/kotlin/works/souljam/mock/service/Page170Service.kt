package works.souljam.mock.service

import works.souljam.mock.entity.Page170Entity
import works.souljam.mock.repository.Page170Repository

import org.springframework.stereotype.Service

@Service
class Page170Service(private val page170Repository: Page170Repository) {

    fun getAllItems(): List<Page170Entity>
            = page170Repository.findAll()

    fun getAllResults(): Map<String, Any> {
        var results = page170Repository.findAll()
        return mapOf("success" to true, "data" to results)
    }

    fun getItemById(id: String): Page170Entity = page170Repository.findById(id)
        .orElseThrow { NoSuchElementException("Product with id $id not found") }

    fun createItem(productEntity: Page170Entity): Page170Entity
            = page170Repository.save(productEntity)

    fun createItems(productEntities: List<Page170Entity>): List<Page170Entity> {
        val entities = productEntities.map { Page170Entity() }

        return page170Repository.saveAll(productEntities)
    }

    fun updateItem(id: String, updatedPage170Entity: Page170Entity): Page170Entity {
        if (!page170Repository.existsById(id)) {
            throw NoSuchElementException("Product with id $id not found")
        }
        updatedPage170Entity.id = id
        return page170Repository.save(updatedPage170Entity)
    }

    fun deleteItem(id: String) {
        if (!page170Repository.existsById(id)) {
            throw NoSuchElementException("Product with id $id not found")
        }
        page170Repository.deleteById(id)
    }
}