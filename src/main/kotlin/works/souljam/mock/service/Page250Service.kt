package works.souljam.mock.service

import works.souljam.mock.entity.Page250Entity
import works.souljam.mock.repository.Page250Repository

import org.springframework.stereotype.Service

@Service
class Page250Service(private val page250Repository: Page250Repository) {

    fun getAllItems(): List<Page250Entity>
            = page250Repository.findAll()

    fun getAllResults(): Map<String, Any> {
        var results = page250Repository.findAll()
        return mapOf("success" to true, "data" to results)
    }

    fun getItemById(id: String): Page250Entity = page250Repository.findById(id)
        .orElseThrow { NoSuchElementException("Product with id $id not found") }

    fun createItem(productEntity: Page250Entity): Page250Entity
            = page250Repository.save(productEntity)

    fun createItems(productEntities: List<Page250Entity>): List<Page250Entity> {
        val entities = productEntities.map { Page250Entity() }

        return page250Repository.saveAll(productEntities)
    }

    fun updateItem(id: String, updatedPage250Entity: Page250Entity): Page250Entity {
        if (!page250Repository.existsById(id)) {
            throw NoSuchElementException("Product with id $id not found")
        }
        updatedPage250Entity.id = id
        return page250Repository.save(updatedPage250Entity)
    }

    fun deleteItem(id: String) {
        if (!page250Repository.existsById(id)) {
            throw NoSuchElementException("Product with id $id not found")
        }
        page250Repository.deleteById(id)
    }
}