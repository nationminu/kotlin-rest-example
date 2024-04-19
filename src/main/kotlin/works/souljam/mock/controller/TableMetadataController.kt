package works.souljam.mock.controller

import com.google.common.base.CaseFormat
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import works.souljam.mock.entity.ProductEntity
import works.souljam.mock.service.ProductService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/table-columns")
class TableMetadataController(@Autowired private val jdbcTemplate: JdbcTemplate) {

    @GetMapping("/{tableName}")
    fun getTableColumns(@PathVariable tableName: String): List<ColumnMetadata> {
        val sql = """
            SELECT column_name, data_type
            FROM information_schema.columns
            WHERE table_name = ?
            AND COLUMN_NAME NOT IN ('id', 'name', 'description', 'created_at', 'created_by', 'updated_by', 'updated_at', 'order_by', 'used')
            ORDER BY ORDINAL_POSITION ASC
        """.trimIndent()

        return jdbcTemplate.query(
            sql,
            arrayOf("tab_" + tableName)
        ) { rs, _ ->
            ColumnMetadata(
                CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, rs.getString("column_name")),
                CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, rs.getString("data_type"))
            )
        }
    }

    @GetMapping("/{tableName}/all")
    fun getTableAllColumns(@PathVariable tableName: String): List<ColumnMetadata> {
        val sql = """
            SELECT column_name, data_type
            FROM information_schema.columns
            WHERE table_name = ?
            AND COLUMN_NAME NOT IN ('id', 'name', 'description', 'created_at', 'created_by', 'updated_by', 'updated_at', 'order_by', 'used')
            ORDER BY ORDINAL_POSITION ASC
        """.trimIndent()

        return jdbcTemplate.query(
            sql,
            arrayOf("tab_" + tableName)
        ) { rs, _ ->
            ColumnMetadata(
                CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, rs.getString("column_name")),
                CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, rs.getString("data_type"))
            )
        }
    }
}

data class ColumnMetadata(val columnName: String, val dataType: String)