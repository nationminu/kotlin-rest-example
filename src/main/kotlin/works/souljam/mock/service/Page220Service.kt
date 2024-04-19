package works.souljam.mock.service

import works.souljam.mock.entity.Page220Entity
import works.souljam.mock.repository.Page220Repository

import org.springframework.stereotype.Service

@Service
class Page220Service(private val page220Repository: Page220Repository) {

    fun getAllItems(): List<Page220Entity>
            = page220Repository.findAll()

    fun getAllResults(): Map<String, Any> {
        var results = page220Repository.findAll()
        return mapOf("success" to true, "data" to results)
    }

    fun getItemById(id: String): Page220Entity = page220Repository.findById(id)
        .orElseThrow { NoSuchElementException("Product with id $id not found") }

    fun createItem(productEntity: Page220Entity): Page220Entity
            = page220Repository.save(productEntity)

    fun createItems(productEntities: List<Page220Entity>): List<Page220Entity> {
        val entities = productEntities.map { Page220Entity() }

        return page220Repository.saveAll(productEntities)
    }

    fun updateItem(id: String, updatedPage220Entity: Page220Entity): Page220Entity {
        if (!page220Repository.existsById(id)) {
            throw NoSuchElementException("Product with id $id not found")
        }
        updatedPage220Entity.id = id
        return page220Repository.save(updatedPage220Entity)
    }

    fun deleteItem(id: String) {
        if (!page220Repository.existsById(id)) {
            throw NoSuchElementException("Product with id $id not found")
        }
        page220Repository.deleteById(id)
    }
}