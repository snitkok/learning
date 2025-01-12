package com.example.helloworld.controller

import com.example.helloworld.service.MyService
import com.example.helloworld.service.dto.PersonData
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException
import org.springframework.web.servlet.function.EntityResponse

//TODO: do I need to create a base class for the controller and then extend it here?
//Where to add the exception handling for the controller?
@RestController
@RequestMapping("/persons")
class PersonController(var myService: MyService) {
    //@Autowired
    @GetMapping
    fun getPersons(): List<PersonData> {
        return myService.getPersons()
    }

    @GetMapping("/{id}")
    fun getPerson(@PathVariable id: Int): ResponseEntity<PersonData?> {
        //TODO :  return 404 (not found) if person not found
        try {
            val person = myService.getPerson(id);
            return ResponseEntity.ok(person);
        } catch (e: NoSuchElementException) {
            println("Person with id $id not found")
            return ResponseEntity.notFound().build()
        }
//        val person = myService.getPerson(id)
//            ?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "Person with id $id not found")
//        return myService.getPerson(id)

    }

    @PostMapping
    fun createPerson(@RequestBody personData: PersonData) {
        return myService.createPerson(personData)
    }

    @PatchMapping("/{id}")
    fun updatePerson(@RequestBody personData: PersonData, @PathVariable id: Int) {
        try {
            return myService.updatePerson(personData, id)
        } catch (e: RuntimeException) {
            println("Database connection failed")

        }
    }


}
