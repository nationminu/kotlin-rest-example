package works.souljam.mock.service

import works.souljam.mock.entity.Page260Entity
import works.souljam.mock.repository.Page260Repository

import org.springframework.stereotype.Service

@Service
class Page260Service(private val page260Repository: Page260Repository) {

    fun getAllItems(): List<Page260Entity>
            = page260Repository.findAll()

    fun getAllResults(): Map<String, Any> {
        var results = page260Repository.findAll()
        return mapOf("success" to true, "data" to results)
    }

    fun getItemById(id: String): Page260Entity = page260Repository.findById(id)
        .orElseThrow { NoSuchElementException("Product with id $id not found") }

    fun createItem(productEntity: Page260Entity): Page260Entity
            = page260Repository.save(productEntity)

    fun createItems(productEntities: List<Page260Entity>): List<Page260Entity> {
        val entities = productEntities.map { Page260Entity() }

        return page260Repository.saveAll(productEntities)
    }

    fun updateItem(id: String, updatedPage260Entity: Page260Entity): Page260Entity {
        if (!page260Repository.existsById(id)) {
            throw NoSuchElementException("Product with id $id not found")
        }
        updatedPage260Entity.id = id
        return page260Repository.save(updatedPage260Entity)
    }

    fun deleteItem(id: String) {
        if (!page260Repository.existsById(id)) {
            throw NoSuchElementException("Product with id $id not found")
        }
        page260Repository.deleteById(id)
    }
}