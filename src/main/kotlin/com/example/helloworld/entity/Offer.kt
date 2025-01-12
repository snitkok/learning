package com.example.helloworld.entity

import jakarta.persistence.*
import java.time.Duration

@Entity
@Table(name = "offers")
class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
//    Can we talk about the types, when does it make sense to make numeric value an int and when a string
    val id: Long = 0
    val offerPercentage: Int = 0
    val duration: Int = 0

//    One offer can be applied to multiple products
    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
//Can it be null
    val product: Product? = null
}