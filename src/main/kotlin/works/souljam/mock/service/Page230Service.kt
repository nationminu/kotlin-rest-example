package works.souljam.mock.service

import works.souljam.mock.entity.Page230Entity
import works.souljam.mock.repository.Page230Repository

import org.springframework.stereotype.Service

@Service
class Page230Service(private val page230Repository: Page230Repository) {

    fun getAllItems(): List<Page230Entity>
            = page230Repository.findAll()

    fun getAllResults(): Map<String, Any> {
        var results = page230Repository.findAll()
        return mapOf("success" to true, "data" to results)
    }

    fun getItemById(id: String): Page230Entity = page230Repository.findById(id)
        .orElseThrow { NoSuchElementException("Product with id $id not found") }

    fun createItem(productEntity: Page230Entity): Page230Entity
            = page230Repository.save(productEntity)

    fun createItems(productEntities: List<Page230Entity>): List<Page230Entity> {
        val entities = productEntities.map { Page230Entity() }

        return page230Repository.saveAll(productEntities)
    }

    fun updateItem(id: String, updatedPage230Entity: Page230Entity): Page230Entity {
        if (!page230Repository.existsById(id)) {
            throw NoSuchElementException("Product with id $id not found")
        }
        updatedPage230Entity.id = id
        return page230Repository.save(updatedPage230Entity)
    }

    fun deleteItem(id: String) {
        if (!page230Repository.existsById(id)) {
            throw NoSuchElementException("Product with id $id not found")
        }
        page230Repository.deleteById(id)
    }
}