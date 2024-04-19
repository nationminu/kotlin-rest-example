package works.souljam.mock.service

import works.souljam.mock.entity.Page140Entity
import works.souljam.mock.repository.Page140Repository

import org.springframework.stereotype.Service

@Service
class Page140Service(private val page140Repository: Page140Repository) {

    fun getAllItems(): List<Page140Entity>
            = page140Repository.findAll()

    fun getAllResults(): Map<String, Any> {
        var results = page140Repository.findAll()
        return mapOf("success" to true, "data" to results)
    }

    fun getItemById(id: String): Page140Entity = page140Repository.findById(id)
        .orElseThrow { NoSuchElementException("Product with id $id not found") }

    fun createItem(productEntity: Page140Entity): Page140Entity
            = page140Repository.save(productEntity)

    fun createItems(productEntities: List<Page140Entity>): List<Page140Entity> {
        val entities = productEntities.map { Page140Entity() }

        return page140Repository.saveAll(productEntities)
    }

    fun updateItem(id: String, updatedPage140Entity: Page140Entity): Page140Entity {
        if (!page140Repository.existsById(id)) {
            throw NoSuchElementException("Product with id $id not found")
        }
        updatedPage140Entity.id = id
        return page140Repository.save(updatedPage140Entity)
    }

    fun deleteItem(id: String) {
        if (!page140Repository.existsById(id)) {
            throw NoSuchElementException("Product with id $id not found")
        }
        page140Repository.deleteById(id)
    }
}