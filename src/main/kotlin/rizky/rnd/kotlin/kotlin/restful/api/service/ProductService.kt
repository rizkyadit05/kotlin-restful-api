package rizky.rnd.kotlin.kotlin.restful.api.service

import rizky.rnd.kotlin.kotlin.restful.api.model.ProductCreateRequest
import rizky.rnd.kotlin.kotlin.restful.api.model.ProductListRequest
import rizky.rnd.kotlin.kotlin.restful.api.model.ProductResponse
import rizky.rnd.kotlin.kotlin.restful.api.model.ProductUpdateRequest

interface ProductService {
    fun create(productCreateRequest: ProductCreateRequest): ProductResponse

    fun get(productId: String): ProductResponse

    fun list(productListRequest: ProductListRequest): List<ProductResponse>

    fun update(productId: String, productUpdateRequest: ProductUpdateRequest): ProductResponse

    fun delete(productId: String)
}