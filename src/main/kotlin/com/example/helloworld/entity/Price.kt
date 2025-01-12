package com.example.helloworld.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table

@Entity
@Table(name = "prices")
class Price {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long = 0
    val currency: String = "" //@ToDo enum
    val amount: Int = 0

    @ManyToOne
//    Do I need to join column or tables in general not just here ???
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    val product: Product? = null
}