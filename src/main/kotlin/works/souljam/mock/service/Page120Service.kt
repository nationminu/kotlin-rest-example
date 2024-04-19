package works.souljam.mock.service

import works.souljam.mock.entity.Page120Entity
import works.souljam.mock.repository.Page120Repository

import org.springframework.stereotype.Service

@Service
class Page120Service(private val page120Repository: Page120Repository) {

    fun getAllItems(): List<Page120Entity>
            = page120Repository.findAll()

    fun getAllResults(): Map<String, Any> {
        var results = page120Repository.findAll()
        return mapOf("success" to true, "data" to results)
    }

    fun getItemById(id: String): Page120Entity = page120Repository.findById(id)
        .orElseThrow { NoSuchElementException("Product with id $id not found") }

    fun createItem(productEntity: Page120Entity): Page120Entity
            = page120Repository.save(productEntity)

    fun createItems(productEntities: List<Page120Entity>): List<Page120Entity> {
        val entities = productEntities.map { Page120Entity() }

        return page120Repository.saveAll(productEntities)
    }

    fun updateItem(id: String, updatedPage120Entity: Page120Entity): Page120Entity {
        if (!page120Repository.existsById(id)) {
            throw NoSuchElementException("Product with id $id not found")
        }
        updatedPage120Entity.id = id
        return page120Repository.save(updatedPage120Entity)
    }

    fun deleteItem(id: String) {
        if (!page120Repository.existsById(id)) {
            throw NoSuchElementException("Product with id $id not found")
        }
        page120Repository.deleteById(id)
    }
}