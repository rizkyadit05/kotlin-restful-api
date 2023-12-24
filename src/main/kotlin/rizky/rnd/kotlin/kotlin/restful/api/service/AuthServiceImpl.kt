package rizky.rnd.kotlin.kotlin.restful.api.service

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import io.jsonwebtoken.security.Keys
import org.springframework.stereotype.Service
import rizky.rnd.kotlin.kotlin.restful.api.error.NotFoundException
import rizky.rnd.kotlin.kotlin.restful.api.model.Auth.LoginRequest
import rizky.rnd.kotlin.kotlin.restful.api.model.WebResponse
import rizky.rnd.kotlin.kotlin.restful.api.repository.LoginDataRepository
import rizky.rnd.kotlin.kotlin.restful.api.validation.ValidationUtil
import java.nio.charset.StandardCharsets
import java.util.*
import javax.crypto.SecretKey
import kotlin.coroutines.ContinuationInterceptor

@Service
class AuthServiceImpl(
    val loginDataRepository: LoginDataRepository,
    val validationUtil: ValidationUtil
): AuthService {
    override fun login(loginRequest: LoginRequest): String {
       validationUtil.validate(loginRequest)

        val user = loginDataRepository.findByEmailAndPassword(
            loginRequest.email,
            loginRequest.password
        ) ?: throw NotFoundException("Wrong email/password")

        val jwt = Jwts.builder()
            .issuer(user.id.toString())
            .expiration(Date(System.currentTimeMillis() + (60 * 24 * 1000))) // 1 day
            .signWith(getSigningKey(), Jwts.SIG.HS512)
            .compact()

        return jwt
    }

    private fun getSigningKey(): SecretKey? {
        val secret = "secret21231231hgfhgfcbvc&^$$^%$%^ghjhjhbhjvhjhfnbnxbcnxcnbbnzb&^%&^%870490294029404bzmbjkhfjkhnv"
        val keyBytes: ByteArray = secret.toByteArray(StandardCharsets.UTF_8)

        return Keys.hmacShaKeyFor(keyBytes)
    }
}