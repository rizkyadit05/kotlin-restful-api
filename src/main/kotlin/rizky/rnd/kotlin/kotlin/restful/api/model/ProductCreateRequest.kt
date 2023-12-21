package rizky.rnd.kotlin.kotlin.restful.api.model

import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull

data class ProductCreateRequest(
    @field:NotBlank
    val productId: String?,

    @field:NotBlank
    val name: String?,

    @field:NotNull
    @field:Min(value = 1)
    val price: Long?,

    @field:NotNull
    @field:Min(value = 0)
    val quantity: Int?
)
