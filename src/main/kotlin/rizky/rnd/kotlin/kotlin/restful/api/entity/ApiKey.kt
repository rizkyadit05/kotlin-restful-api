package rizky.rnd.kotlin.kotlin.restful.api.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "api_key")
data class ApiKey(
    @Id
    @Column(name = "id")
    val id: String
)
