package rizky.rnd.kotlin.kotlin.restful.api.repository

import org.springframework.data.jpa.repository.JpaRepository
import rizky.rnd.kotlin.kotlin.restful.api.entity.Product

interface ProductRepository : JpaRepository<Product, Long> {
    fun existsByProductId(
        productId: String
    ): Boolean

    fun findByProductId(
        productId: String
    ): Product?
}