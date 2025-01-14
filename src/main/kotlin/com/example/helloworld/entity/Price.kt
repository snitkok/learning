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
class Price(
    val currency: String,
    val amount: Int,
    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    var product: Product?
) {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long = 0
}

