package rizky.rnd.kotlin.kotlin.restful.api.repository

import org.springframework.data.jpa.repository.JpaRepository
import rizky.rnd.kotlin.kotlin.restful.api.entity.ApiKey

interface ApiKeyRepository : JpaRepository<ApiKey, String> {
}