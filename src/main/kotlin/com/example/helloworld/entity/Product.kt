package com.example.helloworld.entity

import com.example.helloworld.entity.enums.Action
import com.example.helloworld.entity.enums.Type
import jakarta.persistence.*

@Entity
//Do I use singular or plural here?
@Table(name = "product")

class Product
    (
    @Id
//    What Generation TYpe should I assign
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,
    var actionValue: Int, //percentage for example
    //    val value: Int? = null
    val type: Type,
    val title: String,
    @Enumerated( EnumType.STRING)
    val action: Action, // increase
    val code: String,

//or mappedby @Todo need more context here

@OneToMany(mappedBy = "product")
    val prices: List<Price>

)
