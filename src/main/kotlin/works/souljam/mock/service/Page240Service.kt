package works.souljam.mock.service

import works.souljam.mock.entity.Page240Entity
import works.souljam.mock.repository.Page240Repository

import org.springframework.stereotype.Service

@Service
class Page240Service(private val page240Repository: Page240Repository) {

    fun getAllItems(): List<Page240Entity>
            = page240Repository.findAll()

    fun getAllResults(): Map<String, Any> {
        var results = page240Repository.findAll()
        return mapOf("success" to true, "data" to results)
    }

    fun getItemById(id: String): Page240Entity = page240Repository.findById(id)
        .orElseThrow { NoSuchElementException("Product with id $id not found") }

    fun createItem(productEntity: Page240Entity): Page240Entity
            = page240Repository.save(productEntity)

    fun createItems(productEntities: List<Page240Entity>): List<Page240Entity> {
        val entities = productEntities.map { Page240Entity() }

        return page240Repository.saveAll(productEntities)
    }

    fun updateItem(id: String, updatedPage240Entity: Page240Entity): Page240Entity {
        if (!page240Repository.existsById(id)) {
            throw NoSuchElementException("Product with id $id not found")
        }
        updatedPage240Entity.id = id
        return page240Repository.save(updatedPage240Entity)
    }

    fun deleteItem(id: String) {
        if (!page240Repository.existsById(id)) {
            throw NoSuchElementException("Product with id $id not found")
        }
        page240Repository.deleteById(id)
    }
}