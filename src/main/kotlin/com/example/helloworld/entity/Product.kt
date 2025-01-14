package com.example.helloworld.entity

import com.example.helloworld.entity.enums.Action
import com.example.helloworld.entity.enums.Type
import jakarta.persistence.*

@Entity
@Table(name = "products")
class Product(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val title: String,
    val type: Type,
    val action: Action,
    var actionValue: Int, //percentage for example
    val code: String,

    ) {
    @OneToMany(mappedBy = "product")
    val prices: MutableList<Price> = mutableListOf()

    fun addPrices(vararg newPrices: Price) {
        prices.addAll(newPrices)
    }
}

