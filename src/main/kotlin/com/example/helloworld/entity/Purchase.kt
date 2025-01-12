package com.example.helloworld.entity

import jakarta.persistence.*
import java.time.LocalDateTime


@Entity
@Table(name = "purchases")
class Purchase() {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long = 0
    val createdAt: LocalDateTime = LocalDateTime.now()
    var status: String = ""
    var currency: String = ""

    //    foreign keys
    @OneToOne
//    my table is called productS, it probably won't understand
//    How do I connect it to the products table (Query?)
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    val product: Product? = null

    @OneToOne
    @JoinColumn(name = "price_id", referencedColumnName = "id")
//    Can I assign them to null
    val price: Price? = null

    @ManyToOne
//    should referencedColumnName be always "id"
    @JoinColumn(name = "offer_id", referencedColumnName = "id")
    val offer: Offer? = null
}