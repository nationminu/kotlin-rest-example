package works.souljam.mock.controller

import works.souljam.mock.entity.ProductEntity
import works.souljam.mock.service.ProductService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/")
class MainController {

    @GetMapping
    fun Main(): Map<String, Any> {

        return mapOf("success" to true, "message" to "hello handle")
    }
}