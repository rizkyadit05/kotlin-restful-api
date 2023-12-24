package rizky.rnd.kotlin.kotlin.restful.api.repository

import io.jsonwebtoken.security.Password
import jakarta.validation.constraints.Email
import org.springframework.data.jpa.repository.JpaRepository
import rizky.rnd.kotlin.kotlin.restful.api.entity.LoginData

interface LoginDataRepository : JpaRepository<LoginData, Long> {
    fun findByEmailAndPassword(
        email: String,
        password: String
    ): LoginData?
}