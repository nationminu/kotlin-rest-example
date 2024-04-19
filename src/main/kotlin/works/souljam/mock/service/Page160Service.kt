package works.souljam.mock.service

import works.souljam.mock.entity.Page160Entity
import works.souljam.mock.repository.Page160Repository

import org.springframework.stereotype.Service

@Service
class Page160Service(private val page160Repository: Page160Repository) {

    fun getAllItems(): List<Page160Entity>
            = page160Repository.findAll()

    fun getAllResults(): Map<String, Any> {
        var results = page160Repository.findAll()
        return mapOf("success" to true, "data" to results)
    }

    fun getItemById(id: String): Page160Entity = page160Repository.findById(id)
        .orElseThrow { NoSuchElementException("Product with id $id not found") }

    fun createItem(productEntity: Page160Entity): Page160Entity
            = page160Repository.save(productEntity)

    fun createItems(productEntities: List<Page160Entity>): List<Page160Entity> {
        val entities = productEntities.map { Page160Entity() }

        return page160Repository.saveAll(productEntities)
    }

    fun updateItem(id: String, updatedPage160Entity: Page160Entity): Page160Entity {
        if (!page160Repository.existsById(id)) {
            throw NoSuchElementException("Product with id $id not found")
        }
        updatedPage160Entity.id = id
        return page160Repository.save(updatedPage160Entity)
    }

    fun deleteItem(id: String) {
        if (!page160Repository.existsById(id)) {
            throw NoSuchElementException("Product with id $id not found")
        }
        page160Repository.deleteById(id)
    }
}