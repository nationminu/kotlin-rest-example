package works.souljam.mock.service

import works.souljam.mock.entity.Page110Entity
import works.souljam.mock.repository.Page110Repository

import org.springframework.stereotype.Service

@Service
class Page110Service(private val page110Repository: Page110Repository) {

    fun getAllItems(): List<Page110Entity>
            = page110Repository.findAll()

    fun getAllResults(): Map<String, Any> {
        var results = page110Repository.findAll()
        return mapOf("success" to true, "data" to results)
    }

    fun getItemById(id: String): Page110Entity = page110Repository.findById(id)
        .orElseThrow { NoSuchElementException("Product with id $id not found") }

    fun createItem(productEntity: Page110Entity): Page110Entity
            = page110Repository.save(productEntity)

    fun createItems(productEntities: List<Page110Entity>): List<Page110Entity> {
        val entities = productEntities.map { Page110Entity() }

        return page110Repository.saveAll(productEntities)
    }

    fun updateItem(id: String, updatedPage110Entity: Page110Entity): Page110Entity {
        if (!page110Repository.existsById(id)) {
            throw NoSuchElementException("Product with id $id not found")
        }
        updatedPage110Entity.id = id
        return page110Repository.save(updatedPage110Entity)
    }

    fun deleteItem(id: String) {
        if (!page110Repository.existsById(id)) {
            throw NoSuchElementException("Product with id $id not found")
        }
        page110Repository.deleteById(id)
    }
}