package rizky.rnd.kotlin.kotlin.restful.api.auth

import org.springframework.stereotype.Component
import org.springframework.ui.ModelMap
import org.springframework.web.context.request.WebRequest
import org.springframework.web.context.request.WebRequestInterceptor
import rizky.rnd.kotlin.kotlin.restful.api.error.UnauthorizedException
import rizky.rnd.kotlin.kotlin.restful.api.repository.ApiKeyRepository
import java.lang.Exception

@Component
class ApiKeyInterceptor(val apiKeyRepository: ApiKeyRepository): WebRequestInterceptor {
    override fun preHandle(request: WebRequest) {
        var apiKey = request.getHeader("X-Api-Key") ?: throw UnauthorizedException()

        if (!apiKeyRepository.existsById(apiKey)) {
            throw UnauthorizedException()
        }
    }

    override fun postHandle(request: WebRequest, model: ModelMap?) {
        // no need
    }

    override fun afterCompletion(request: WebRequest, ex: Exception?) {
        // no need
    }

}