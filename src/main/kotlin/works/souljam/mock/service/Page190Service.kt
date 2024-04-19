package works.souljam.mock.service

import works.souljam.mock.entity.Page190Entity
import works.souljam.mock.repository.Page190Repository

import org.springframework.stereotype.Service

@Service
class Page190Service(private val page190Repository: Page190Repository) {

    fun getAllItems(): List<Page190Entity>
            = page190Repository.findAll()

    fun getAllResults(): Map<String, Any> {
        var results = page190Repository.findAll()
        return mapOf("success" to true, "data" to results)
    }

    fun getItemById(id: String): Page190Entity = page190Repository.findById(id)
        .orElseThrow { NoSuchElementException("Product with id $id not found") }

    fun createItem(productEntity: Page190Entity): Page190Entity
            = page190Repository.save(productEntity)

    fun createItems(productEntities: List<Page190Entity>): List<Page190Entity> {
        val entities = productEntities.map { Page190Entity() }

        return page190Repository.saveAll(productEntities)
    }

    fun updateItem(id: String, updatedPage190Entity: Page190Entity): Page190Entity {
        if (!page190Repository.existsById(id)) {
            throw NoSuchElementException("Product with id $id not found")
        }
        updatedPage190Entity.id = id
        return page190Repository.save(updatedPage190Entity)
    }

    fun deleteItem(id: String) {
        if (!page190Repository.existsById(id)) {
            throw NoSuchElementException("Product with id $id not found")
        }
        page190Repository.deleteById(id)
    }
}