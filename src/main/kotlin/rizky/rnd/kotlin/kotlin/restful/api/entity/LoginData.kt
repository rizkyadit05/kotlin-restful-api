package rizky.rnd.kotlin.kotlin.restful.api.entity

import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.util.*

@Entity
@Table(name="product")
data class Product(
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val primaryId:Long? = null,

    @Column(name = "product_id")
    val productId: String,

    @Column(name = "name")
    var name: String,

    @Column(name = "price")
    var price: Long,

    @Column(name = "quantity")
    var quantity: Int,

    @Column(name = "created_at")
    @CreationTimestamp
    val createdAt: Date,

    @Column(name = "updatedAt")
    @UpdateTimestamp
    var updatedAt: Date?
)