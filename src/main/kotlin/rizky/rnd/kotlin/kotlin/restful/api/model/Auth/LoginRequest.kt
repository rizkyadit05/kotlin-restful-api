package rizky.rnd.kotlin.kotlin.restful.api.model.Auth

import io.jsonwebtoken.security.Password
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank

data class LoginRequest(
    @field:NotBlank
    val email: String,

    @field:NotBlank
    val password: String
)
