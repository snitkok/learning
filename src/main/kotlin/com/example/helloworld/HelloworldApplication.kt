package com.example.helloworld

import com.example.helloworld.entity.Product
import com.example.helloworld.entity.enums.Action
import com.example.helloworld.entity.enums.Type
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class HelloworldApplication

fun main(args: Array<String>) {
	runApplication<HelloworldApplication>(*args)
}
val product = Product(1, "energyBoost", Type.ENERGY, Action.INCREASE, 100, "2eb")
