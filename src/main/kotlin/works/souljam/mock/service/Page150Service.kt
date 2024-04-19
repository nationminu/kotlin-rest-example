package works.souljam.mock.service

import works.souljam.mock.entity.Page150Entity
import works.souljam.mock.repository.Page150Repository

import org.springframework.stereotype.Service

@Service
class Page150Service(private val page150Repository: Page150Repository) {

    fun getAllItems(): List<Page150Entity>
            = page150Repository.findAll()

    fun getAllResults(): Map<String, Any> {
        var results = page150Repository.findAll()
        return mapOf("success" to true, "data" to results)
    }

    fun getItemById(id: String): Page150Entity = page150Repository.findById(id)
        .orElseThrow { NoSuchElementException("Product with id $id not found") }

    fun createItem(productEntity: Page150Entity): Page150Entity
            = page150Repository.save(productEntity)

    fun createItems(productEntities: List<Page150Entity>): List<Page150Entity> {
        val entities = productEntities.map { Page150Entity() }

        return page150Repository.saveAll(productEntities)
    }

    fun updateItem(id: String, updatedPage150Entity: Page150Entity): Page150Entity {
        if (!page150Repository.existsById(id)) {
            throw NoSuchElementException("Product with id $id not found")
        }
        updatedPage150Entity.id = id
        return page150Repository.save(updatedPage150Entity)
    }

    fun deleteItem(id: String) {
        if (!page150Repository.existsById(id)) {
            throw NoSuchElementException("Product with id $id not found")
        }
        page150Repository.deleteById(id)
    }
}