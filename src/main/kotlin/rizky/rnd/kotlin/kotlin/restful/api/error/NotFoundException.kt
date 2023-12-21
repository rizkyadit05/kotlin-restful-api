package rizky.rnd.kotlin.kotlin.restful.api.error

class NotFoundException(
    override val message: String,
    val additionalInfo: Any? = null
): RuntimeException()