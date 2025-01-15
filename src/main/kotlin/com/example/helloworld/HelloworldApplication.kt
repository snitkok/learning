package com.example.helloworld

import com.example.helloworld.entity.Product
import com.example.helloworld.entity.enums.Action
import com.example.helloworld.entity.enums.Type
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class HelloworldApplication

fun main(args: Array<String>) {
	runApplication<HelloworldApplication>(*args)
}