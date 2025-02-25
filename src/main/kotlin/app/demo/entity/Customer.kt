package app.demo.entity

import jakarta.persistence.*
import lombok.Getter
import lombok.Setter

@Entity
class Customer (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    @Column(nullable = false)
    var name: String? = null,
    @Column(nullable = false, unique = true)
    var email: String? = null
)