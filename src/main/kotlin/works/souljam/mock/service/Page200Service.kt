package works.souljam.mock.service

import works.souljam.mock.entity.Page200Entity
import works.souljam.mock.repository.Page200Repository

import org.springframework.stereotype.Service

@Service
class Page200Service(private val page200Repository: Page200Repository) {

    fun getAllItems(): List<Page200Entity>
            = page200Repository.findAll()

    fun getAllResults(): Map<String, Any> {
        var results = page200Repository.findAll()
        return mapOf("success" to true, "data" to results)
    }

    fun getItemById(id: String): Page200Entity = page200Repository.findById(id)
        .orElseThrow { NoSuchElementException("Product with id $id not found") }

    fun createItem(productEntity: Page200Entity): Page200Entity
            = page200Repository.save(productEntity)

    fun createItems(productEntities: List<Page200Entity>): List<Page200Entity> {
        val entities = productEntities.map { Page200Entity() }

        return page200Repository.saveAll(productEntities)
    }

    fun updateItem(id: String, updatedPage200Entity: Page200Entity): Page200Entity {
        if (!page200Repository.existsById(id)) {
            throw NoSuchElementException("Product with id $id not found")
        }
        updatedPage200Entity.id = id
        return page200Repository.save(updatedPage200Entity)
    }

    fun deleteItem(id: String) {
        if (!page200Repository.existsById(id)) {
            throw NoSuchElementException("Product with id $id not found")
        }
        page200Repository.deleteById(id)
    }
}