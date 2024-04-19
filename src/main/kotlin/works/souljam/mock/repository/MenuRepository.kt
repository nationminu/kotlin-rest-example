package works.souljam.mock.repository

import org.springframework.data.jpa.repository.JpaRepository
import works.souljam.mock.entity.MenuEntity

interface MenuRepository : JpaRepository<MenuEntity, String>