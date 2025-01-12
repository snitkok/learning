package com.example.helloworld.service

import com.example.helloworld.service.dto.PersonData
import com.example.helloworld.service.dto.PersonDto
import org.springframework.stereotype.Service

@Service
class MyService {

    private var persons = mutableListOf<PersonData>()

    fun createPerson(personData: PersonData) {
        //TODO :  prevent duplicate entry with same Id
        //TODO : use Set here --> equals and hashcode
        val existingPerson = persons.find { it.id == personData.id };
        if (existingPerson != null) {
        //  auto-suggestion throw IllegalArgumentException("Person with id ${personData.id} already exists")
            println("Person with this id already exists")
        } else {
            persons.add(personData)
        }
    }

    fun updatePerson(updatedPerson: PersonData, id: Int) {
        // TODO : find the right person and replace it
        val rightPerson = persons.find { it.id == id };
        if (rightPerson != null) {
            rightPerson.name = updatedPerson.name
        } else {
            println("Person with this id does not exist")
        }
    }

    fun getPersons(): List<PersonData> {
        return persons
    }

    fun getPerson(id: Int): PersonData? {
        // TODO: find person from the list and return it
        // TODO:  throw exception if person not found
        val rightPerson = persons.find { it.id == id };
        return rightPerson ?: throw NoSuchElementException("Person with id $id not found");

    }

    fun dummyMethod() : PersonDto {
        val p  = PersonDto(1, "Katja");
        p.name = "Amir";
        return p;
    }
}