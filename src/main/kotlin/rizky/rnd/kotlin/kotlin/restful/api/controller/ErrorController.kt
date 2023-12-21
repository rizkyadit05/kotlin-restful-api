package rizky.rnd.kotlin.kotlin.restful.api.controller

import jakarta.validation.ConstraintViolationException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import rizky.rnd.kotlin.kotlin.restful.api.error.NotFoundException
import rizky.rnd.kotlin.kotlin.restful.api.error.UnauthorizedException
import rizky.rnd.kotlin.kotlin.restful.api.model.WebResponse
import java.sql.SQLIntegrityConstraintViolationException

@RestControllerAdvice
class ErrorController  {
    @ExceptionHandler(value = [ConstraintViolationException::class])
    fun validationHandler(constrainViolationException: ConstraintViolationException): WebResponse<String> {
        return WebResponse(
            code = 400,
            status = "BAD REQUEST",
            data = constrainViolationException.message!!
        )
    }

    @ExceptionHandler(value = [SQLIntegrityConstraintViolationException::class])
    fun dataValidationHandler(
        sqlIntegrityConstraintViolationException: SQLIntegrityConstraintViolationException
    ): WebResponse<String> {
        return WebResponse(
            code = 400,
            status = "BAD REQUEST",
            data = sqlIntegrityConstraintViolationException.message!!
        )
    }

    @ExceptionHandler(value = [NotFoundException::class])
    fun notFoundHandler(
        notFoundException: NotFoundException
    ): WebResponse<String> {
        return WebResponse(
            code = 404,
            status = "NOT FOUND",
            data = "message: " +
                    notFoundException.message +
                    " | additional info: " +
                    notFoundException.additionalInfo
        )
    }

    @ExceptionHandler(value = [UnauthorizedException::class])
    fun unauthorizedHandler(
        unauthorizedException: UnauthorizedException
    ): WebResponse<String> {
        return WebResponse(
            code = 401,
            status = "UNAUTHORIZED",
            data = "Unauthorized"
        )
    }
}