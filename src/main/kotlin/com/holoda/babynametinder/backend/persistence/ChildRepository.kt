package com.holoda.babynametinder.backend.persistence

import com.holoda.babynametinder.backend.model.Child
import org.springframework.data.repository.CrudRepository

interface ChildRepository : CrudRepository<Child, Long>