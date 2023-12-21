package rizky.rnd.kotlin.kotlin.restful.api.controller

import org.springframework.web.bind.annotation.*
import rizky.rnd.kotlin.kotlin.restful.api.model.*
import rizky.rnd.kotlin.kotlin.restful.api.service.ProductService

@RestController
class ProductController(val productService: ProductService) {
    @PostMapping(
        value = ["/api/products"],
        produces = ["application/json"],
        consumes = ["application/json"]
    )
    fun createProduct(@RequestBody productCreateRequest: ProductCreateRequest): WebResponse<ProductResponse> {
        val productResponse = productService.create(productCreateRequest)

        return WebResponse(
            code = 200,
            status = "OK",
            data = productResponse
        )
    }

    @GetMapping(
        value = ["/api/products/{productId}"],
        produces = ["application/json"]
    )
    fun getProduct(@PathVariable("productId") productId: String): WebResponse<ProductResponse> {
        val productResponse = productService.get(productId)

        return WebResponse(
            code = 200,
            status = "OK",
            data = productResponse
        )
    }

    @GetMapping(
        value = ["/api/products/list"],
        produces = ["application/json"]
    )
    fun getList(
        @RequestParam(value = "page", defaultValue = "0") page: Int,
        @RequestParam(value = "size", defaultValue = "10") size: Int
    ): WebResponse<List<ProductResponse>> {
        val productListRequest = ProductListRequest(page = page, size = size)
        val productList = productService.list(productListRequest)

        return WebResponse(
            code = 200,
            status = "OK",
            data = productList
        )
    }

    @PutMapping(
        value = ["/api/products/{productId}"],
        produces = ["application/json"],
        consumes = ["application/json"]

    )
    fun updateProduct(
        @PathVariable("productId") productId: String,
        @RequestBody productUpdateRequest: ProductUpdateRequest
    ): WebResponse<ProductResponse> {
        val productResponse = productService.update(productId, productUpdateRequest)

        return WebResponse(
            code = 200,
            status = "OK",
            data = productResponse
        )
    }

    @DeleteMapping(
        value = ["/api/products/{productId}"],
        produces = ["application/json"]
    )
    fun deleteProduct(@PathVariable productId: String): WebResponse <String> {
        productService.delete(productId)

        return WebResponse(
            code = 200,
            status = "OK",
            data = "$productId DELETED"
        )
    }
}