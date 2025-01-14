package com.example.helloworld.entity

import ProductRepository
import com.example.helloworld.HelloworldApplication
import com.example.helloworld.entity.enums.Action
import com.example.helloworld.entity.enums.Type
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig

@DataJpaTest
@SpringJUnitConfig(HelloworldApplication::class)
class ProductTest {

    @Autowired
    lateinit var productRepository: ProductRepository  // Field injection for repository

    val product = Product(1, "Test Product", Type.ENERGY, Action.INCREASE, 100, "2eb")
    val price1 = Price(currency = "USD", amount = 100, product = product)
    val price2 = Price(currency = "EUR", amount = 90, product = product)

    @Test
    fun `should persist and retrieve a product`() {
        product.addPrices(price1, price2)
        productRepository.save(product)
        val persistedProducts = productRepository.findAll()
        assertEquals(persistedProducts.size, 1)
        assertEquals(persistedProducts[0].title, "Test Product")
    }
}
