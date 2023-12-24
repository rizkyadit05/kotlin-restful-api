package rizky.rnd.kotlin.kotlin.restful.api.auth

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.security.Keys
import org.springframework.stereotype.Component
import org.springframework.ui.ModelMap
import org.springframework.web.context.request.WebRequest
import org.springframework.web.context.request.WebRequestInterceptor
import rizky.rnd.kotlin.kotlin.restful.api.error.UnauthorizedException
import rizky.rnd.kotlin.kotlin.restful.api.repository.ApiKeyRepository
import java.nio.charset.StandardCharsets

@Component
class ApiKeyInterceptor(val apiKeyRepository: ApiKeyRepository): WebRequestInterceptor {

    private val whiteListUris = arrayOf(
        "/api/login"
    )
    override fun preHandle(request: WebRequest) {
        val uri = request.getDescription(false).removePrefix("uri=")

        if (!isWhitelistedUri(whiteListUris, uri)) {
            val token = request.getHeader("X-Api-Token") ?: throw UnauthorizedException()

            val secret = "secret21231231hgfhgfcbvc&^$$^%$%^ghjhjhbhjvhjhfnbnxbcnxcnbbnzb&^%&^%870490294029404bzmbjkhfjkhnv"
            val keyBytes: ByteArray = secret.toByteArray(StandardCharsets.UTF_8)
            val key = Keys.hmacShaKeyFor(keyBytes)
            val jwtParser = Jwts.parser().verifyWith(key).build()

            try {
                jwtParser.parse(token)
            }
            catch (e: Exception) {
                throw UnauthorizedException()
            }
        }
    }

    override fun postHandle(request: WebRequest, model: ModelMap?) {
        // no need
    }

    override fun afterCompletion(request: WebRequest, ex: Exception?) {
        // no need
    }

    private fun isWhitelistedUri(whiteListUris: Array<String>, uri: String): Boolean {
        whiteListUris.forEach {
            if (uri == it) {
                return true
            }
        }

        return false
    }
}