package works.souljam.mock.service

import works.souljam.mock.entity.MenuEntity
import works.souljam.mock.repository.MenuRepository

import org.springframework.stereotype.Service

@Service
class MenuService(private val menuRepository: MenuRepository) {

    fun getAllItems(): List<MenuEntity>
            = menuRepository.findAll()

    fun getAllResults(): Map<String, Any> {
        var results = menuRepository.findAll()
        return mapOf("success" to true, "data" to results)
    }

    fun getItemById(id: String): MenuEntity = menuRepository.findById(id)
        .orElseThrow { NoSuchElementException("Item with id $id not found") }

    fun createItem(menuEntity: MenuEntity): MenuEntity
            = menuRepository.save(menuEntity)

    fun createItems(productEntities: List<MenuEntity>): List<MenuEntity> {
        val entities = productEntities.map { MenuEntity() }

        return menuRepository.saveAll(productEntities)
    }

    fun updateItem(id: String, updatedMenuEntity: MenuEntity): MenuEntity {
        if (!menuRepository.existsById(id)) {
            throw NoSuchElementException("Item with id $id not found")
        }
        updatedMenuEntity.id = id
        return menuRepository.save(updatedMenuEntity)
    }

    fun deleteItem(id: String) {
        if (!menuRepository.existsById(id)) {
            throw NoSuchElementException("Item with id $id not found")
        }
        menuRepository.deleteById(id)
    }

    fun getAllMenusHierarchical(): List<MenuEntity> {
        val allMenus = menuRepository.findAll()
        val rootMenus = allMenus.filter { it.parentId == null }
        return rootMenus.map { buildMenuNode(it, allMenus) }
    }

    fun buildMenuNode(menu: MenuEntity, allMenus: List<MenuEntity>): MenuEntity {
        val children = allMenus.filter { it.parentId == menu.id }
        menu.children = children.toMutableList()
        return menu
    }
}