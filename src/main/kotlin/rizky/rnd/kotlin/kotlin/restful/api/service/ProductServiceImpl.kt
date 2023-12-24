package rizky.rnd.kotlin.kotlin.restful.api.service

import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service
import rizky.rnd.kotlin.kotlin.restful.api.entity.Product
import rizky.rnd.kotlin.kotlin.restful.api.error.NotFoundException
import rizky.rnd.kotlin.kotlin.restful.api.model.ProductCreateRequest
import rizky.rnd.kotlin.kotlin.restful.api.model.ProductListRequest
import rizky.rnd.kotlin.kotlin.restful.api.model.ProductResponse
import rizky.rnd.kotlin.kotlin.restful.api.model.ProductUpdateRequest
import rizky.rnd.kotlin.kotlin.restful.api.repository.ProductRepository
import rizky.rnd.kotlin.kotlin.restful.api.validation.ValidationUtil
import java.sql.SQLIntegrityConstraintViolationException
import java.util.*
import java.util.stream.Collectors

@Service
class ProductServiceImpl(
    val productRepository: ProductRepository,
    val validationUtil: ValidationUtil
): ProductService {
    override fun create(productCreateRequest: ProductCreateRequest): ProductResponse {
        validationUtil.validate(productCreateRequest)

        val product = Product(
            productId = productCreateRequest.productId!!,
            name = productCreateRequest.name!!,
            price = productCreateRequest.price!!,
            quantity = productCreateRequest.quantity!!,
            createdAt = Date(),
            updatedAt = null
        )

        if (!productRepository.existsByProductId(product.productId)) {
            productRepository.saveAndFlush(product)
        }
        else {
            throw SQLIntegrityConstraintViolationException("Product ID already exists!")
        }

        return convertProductToProductResponse(product)
    }

    override fun get(productId: String): ProductResponse {
        val product = findOrThrowException(productId)

        return convertProductToProductResponse(product)
    }

    override fun list(productListRequest: ProductListRequest): List<ProductResponse> {
        val page = productRepository.findAll(
            PageRequest.of(productListRequest.page, productListRequest.size)
        )

        val products: List<Product> = page.content

        return products.map { convertProductToProductResponse(it) }
    }

    override fun update(
        productId: String,
        productUpdateRequest: ProductUpdateRequest
    ): ProductResponse {
        val product = findOrThrowException(productId)

        validationUtil.validate(productUpdateRequest)

        product.apply {
            name = productUpdateRequest.name!!
            price = productUpdateRequest.price!!
            quantity = productUpdateRequest.quantity!!
        }

        productRepository.saveAndFlush(product)

        return convertProductToProductResponse(product)
    }

    override fun delete(productId: String) {
        val product = findOrThrowException(productId)

        productRepository.delete(product)
    }

    private fun findOrThrowException(productId: String): Product {
        val product = productRepository.findByProductId(productId)
            ?: throw NotFoundException("Data is not found!")

        return product
    }

    private fun convertProductToProductResponse(product: Product): ProductResponse {
        return ProductResponse(
            productId = product.productId,
            name = product.name,
            price = product.price,
            quantity = product.quantity,
            createdAt = product.createdAt,
            updatedAt = product.updatedAt
        )
    }
}