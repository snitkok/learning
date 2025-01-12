package com.example.helloworld.entity

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest

@DataJpaTest

class ProductTest( val productRepository : ProductRepository ) {

    @Test
    fun `should persist and retrieve a product`() {
        val product = Product()
        productRepository.save(product)
        val persistedProducts = productRepository.findAll()
        assertEquals(persistedProducts.size(), 1)
        assertEquals(persistedProducts[0].title, "")
    }

}