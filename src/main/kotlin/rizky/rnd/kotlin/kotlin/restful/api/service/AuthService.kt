package rizky.rnd.kotlin.kotlin.restful.api.service

import rizky.rnd.kotlin.kotlin.restful.api.model.Auth.LoginRequest
import rizky.rnd.kotlin.kotlin.restful.api.model.WebResponse

interface AuthService {
    fun login(loginRequest: LoginRequest): String
}