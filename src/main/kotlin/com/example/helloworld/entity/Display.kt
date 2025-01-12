package com.example.helloworld.entity

import jakarta.persistence.*

@Entity
@Table(name = "display")
class Display {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long = 0

    val placement: String = ""

    val priority: String = ""

    @ManyToMany
//    'Many To Many' attribute type should be a container  what does this error mean?
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    val product: Product? = null
}