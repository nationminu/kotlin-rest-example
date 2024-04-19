package works.souljam.mock.service

import works.souljam.mock.entity.CodeEntity
import works.souljam.mock.repository.CodeRepository

import org.springframework.stereotype.Service

@Service
class CodeService(private val codeRepository: CodeRepository) {

    fun getAllItems(): List<CodeEntity>
            = codeRepository.findAll()

    fun getAllResults(): Map<String, Any> {
        var results = codeRepository.findAll()
        return mapOf("success" to true, "data" to results)
    }

    fun getItemById(id: String): CodeEntity = codeRepository.findById(id)
        .orElseThrow { NoSuchElementException("Item with id $id not found") }

    fun createItem(codeEntity: CodeEntity): CodeEntity
            = codeRepository.save(codeEntity)

    fun createItems(productEntities: List<CodeEntity>): List<CodeEntity> {
        val entities = productEntities.map { CodeEntity() }

        return codeRepository.saveAll(productEntities)
    }

    fun updateItem(id: String, updatedEntity: CodeEntity): CodeEntity {
        if (!codeRepository.existsById(id)) {
            throw NoSuchElementException("Item with id $id not found")
        }
        updatedEntity.id = id
        return codeRepository.save(updatedEntity)
    }

    fun deleteItem(id: String) {
        if (!codeRepository.existsById(id)) {
            throw NoSuchElementException("Item with id $id not found")
        }
        codeRepository.deleteById(id)
    }
}