package works.souljam.mock.service

import works.souljam.mock.entity.Page210Entity
import works.souljam.mock.repository.Page210Repository

import org.springframework.stereotype.Service

@Service
class Page210Service(private val page210Repository: Page210Repository) {

    fun getAllItems(): List<Page210Entity>
            = page210Repository.findAll()

    fun getAllResults(): Map<String, Any> {
        var results = page210Repository.findAll()
        return mapOf("success" to true, "data" to results)
    }

    fun getItemById(id: String): Page210Entity = page210Repository.findById(id)
        .orElseThrow { NoSuchElementException("Product with id $id not found") }

    fun createItem(productEntity: Page210Entity): Page210Entity
            = page210Repository.save(productEntity)

    fun createItems(productEntities: List<Page210Entity>): List<Page210Entity> {
        val entities = productEntities.map { Page210Entity() }

        return page210Repository.saveAll(productEntities)
    }

    fun updateItem(id: String, updatedPage210Entity: Page210Entity): Page210Entity {
        if (!page210Repository.existsById(id)) {
            throw NoSuchElementException("Product with id $id not found")
        }
        updatedPage210Entity.id = id
        return page210Repository.save(updatedPage210Entity)
    }

    fun deleteItem(id: String) {
        if (!page210Repository.existsById(id)) {
            throw NoSuchElementException("Product with id $id not found")
        }
        page210Repository.deleteById(id)
    }
}