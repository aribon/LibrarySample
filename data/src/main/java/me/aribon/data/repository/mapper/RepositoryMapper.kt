package me.aribon.data.repository.mapper

import java.util.ArrayList

abstract class RepositoryMapper<out ENTITY, in SOURCE> where ENTITY : Any, SOURCE : Any {

  abstract fun map(value: SOURCE): ENTITY

  fun map(values: Collection<SOURCE>): Collection<ENTITY> {
    val returnValues = ArrayList<ENTITY>(values.size)
    for (value in values) {
      if (value != null)
        returnValues.add(map(value))
    }
    return returnValues
  }
}