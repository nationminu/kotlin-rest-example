package works.souljam.mock.service

import works.souljam.mock.entity.Page270Entity
import works.souljam.mock.repository.Page270Repository

import org.springframework.stereotype.Service

@Service
class Page270Service(private val page270Repository: Page270Repository) {

    fun getAllItems(): List<Page270Entity>
            = page270Repository.findAll()

    fun getAllResults(): Map<String, Any> {
        var results = page270Repository.findAll()
        return mapOf("success" to true, "data" to results)
    }

    fun getItemById(id: String): Page270Entity = page270Repository.findById(id)
        .orElseThrow { NoSuchElementException("Product with id $id not found") }

    fun createItem(productEntity: Page270Entity): Page270Entity
            = page270Repository.save(productEntity)

    fun createItems(productEntities: List<Page270Entity>): List<Page270Entity> {
        val entities = productEntities.map { Page270Entity() }

        return page270Repository.saveAll(productEntities)
    }

    fun updateItem(id: String, updatedPage270Entity: Page270Entity): Page270Entity {
        if (!page270Repository.existsById(id)) {
            throw NoSuchElementException("Product with id $id not found")
        }
        updatedPage270Entity.id = id
        return page270Repository.save(updatedPage270Entity)
    }

    fun deleteItem(id: String) {
        if (!page270Repository.existsById(id)) {
            throw NoSuchElementException("Product with id $id not found")
        }
        page270Repository.deleteById(id)
    }
}