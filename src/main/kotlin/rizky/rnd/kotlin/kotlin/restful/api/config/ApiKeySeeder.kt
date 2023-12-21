package rizky.rnd.kotlin.kotlin.restful.api.config

import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component
import rizky.rnd.kotlin.kotlin.restful.api.entity.ApiKey
import rizky.rnd.kotlin.kotlin.restful.api.repository.ApiKeyRepository

@Component
data class ApiKeySeeder(val apiKeyRepository: ApiKeyRepository) : ApplicationRunner {

    private val staticApiKey = "staticSecret"

    override fun run(args: ApplicationArguments?) {
        if (!apiKeyRepository.existsById(staticApiKey)) {
            val apiKey = ApiKey(id = staticApiKey)

            apiKeyRepository.saveAndFlush(apiKey)
        }
    }
}
