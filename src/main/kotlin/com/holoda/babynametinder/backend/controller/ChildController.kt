package com.holoda.babynametinder.backend.controller

import com.holoda.babynametinder.backend.model.Child
import com.holoda.babynametinder.backend.persistence.ChildRepository
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/children")
class ChildController(val repository: ChildRepository) {

    @GetMapping
    fun findAll() = repository.findAll()

    @PostMapping
    fun addChild(@RequestBody user: Child)
            = repository.save(user)

    @PutMapping("/{id}")
    fun updateChild(@PathVariable id: Long, @RequestBody child: Child) {
        assert(child.id == id)
        repository.save(child)
    }

    @DeleteMapping("/{id}")
    fun removeChild(@PathVariable id: Long)
            = repository.delete(id)

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long)
            = repository.findOne(id)
}