package rizky.rnd.kotlin.kotlin.restful.api.entity

import io.jsonwebtoken.security.Password
import jakarta.persistence.*
import jakarta.validation.constraints.Email
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.util.*

@Entity
@Table(name="login_data")
data class LoginData(
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id:Long? = null,

    @Column(name = "name")
    var name: String,

    @Column(name = "email")
    var email: String,

    @Column(name = "password")
    var password: String,

    @Column(name = "created_at")
    @CreationTimestamp
    val createdAt: Date,

    @Column(name = "updatedAt")
    @UpdateTimestamp
    var updatedAt: Date?
)