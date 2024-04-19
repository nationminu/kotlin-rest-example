package works.souljam.mock.service

import works.souljam.mock.entity.CodeTypeEntity
import works.souljam.mock.repository.CodeTypeRepository

import org.springframework.stereotype.Service

@Service
class CodeTypeService(private val codeTypeRepository: CodeTypeRepository) {

    fun getAllItems(): List<CodeTypeEntity>
            = codeTypeRepository.findAll()

    fun getAllResults(): Map<String, Any> {
        var results = codeTypeRepository.findAll()
        return mapOf("success" to true, "data" to results)
    }

    fun getItemById(id: String): CodeTypeEntity = codeTypeRepository.findById(id)
        .orElseThrow { NoSuchElementException("Item with id $id not found") }

    fun createItem(codeTypeEntity: CodeTypeEntity): CodeTypeEntity
            = codeTypeRepository.save(codeTypeEntity)

    fun createItems(productEntities: List<CodeTypeEntity>): List<CodeTypeEntity> {
        val entities = productEntities.map { CodeTypeEntity() }

        return codeTypeRepository.saveAll(productEntities)
    }

    fun updateItem(id: String, updatedEntity: CodeTypeEntity): CodeTypeEntity {
        if (!codeTypeRepository.existsById(id)) {
            throw NoSuchElementException("Item with id $id not found")
        }
        updatedEntity.id = id
        return codeTypeRepository.save(updatedEntity)
    }

    fun deleteItem(id: String) {
        if (!codeTypeRepository.existsById(id)) {
            throw NoSuchElementException("Item with id $id not found")
        }
        codeTypeRepository.deleteById(id)
    }
}