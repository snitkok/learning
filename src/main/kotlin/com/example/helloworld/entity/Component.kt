package com.example.helloworld.entity

import jakarta.persistence.*

@Entity
@Table(name = "combo_products")
class Component {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long = 0

//    One product can be part of multiple combos
    @OneToMany
//    'One To Many' attribute type should be a container. Why?
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    val product: Product? = null
}