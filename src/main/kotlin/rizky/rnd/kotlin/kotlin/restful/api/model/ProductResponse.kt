package rizky.rnd.kotlin.kotlin.restful.api.model

import java.util.*

data class ProductResponse(
    val productId: String,
    val name: String,
    val price: Long,
    val quantity: Int,
    val createdAt: Date?,
    val updatedAt: Date?
)
