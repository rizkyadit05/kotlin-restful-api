package rizky.rnd.kotlin.kotlin.restful.api.controller

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import rizky.rnd.kotlin.kotlin.restful.api.model.Auth.LoginRequest
import rizky.rnd.kotlin.kotlin.restful.api.model.WebResponse

@RestController
class AuthController {
    @PostMapping(
        value = ["/api/login"],
        produces = ["application/json"],
        consumes = ["application/json"]
    )
    fun login(@RequestBody loginRequest: LoginRequest): WebResponse<String> {


        return WebResponse(
            code = 200,
            status = "OK",
            data = "hehe masuk brok"
        )
    }
}