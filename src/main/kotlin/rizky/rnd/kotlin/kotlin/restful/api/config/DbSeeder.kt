package rizky.rnd.kotlin.kotlin.restful.api.config

import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component
import rizky.rnd.kotlin.kotlin.restful.api.entity.ApiKey
import rizky.rnd.kotlin.kotlin.restful.api.entity.LoginData
import rizky.rnd.kotlin.kotlin.restful.api.repository.ApiKeyRepository
import rizky.rnd.kotlin.kotlin.restful.api.repository.LoginDataRepository

@Component
data class DbSeeder(
    val apiKeyRepository: ApiKeyRepository,
    val loginDataRepository: LoginDataRepository
) : ApplicationRunner {

    private val staticApiKey = "staticSecret"
    private val email = "hajikempet@gmail.com"
    private val password = "hajikempet123"

    override fun run(args: ApplicationArguments?) {
        if (!apiKeyRepository.existsById(staticApiKey)) {
            val apiKey = ApiKey(id = staticApiKey)

            apiKeyRepository.saveAndFlush(apiKey)
        }

        if (!loginDataRepository.existsById(0)) {
            val loginData = LoginData(
                name = "Haji Kempet",
                email = "hajikempet@gmail.com",
                password = "hajikempet123"
            )

            loginDataRepository.saveAndFlush(loginData)
        }
    }
}
