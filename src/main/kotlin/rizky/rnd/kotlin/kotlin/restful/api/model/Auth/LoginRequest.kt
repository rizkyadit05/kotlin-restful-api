package rizky.rnd.kotlin.kotlin.restful.api.model.Auth

import jakarta.validation.constraints.NotBlank

data class LoginRequest(
    @field:NotBlank
    val username: String?,

    @field:NotBlank
    val password: String?
)
