package me.aribon.presentation.mapper

abstract class ViewModelMapper<ENTITY, VM> where ENTITY : Any, VM : Any {

  abstract fun toEntity(value: VM): ENTITY

  abstract fun fromEntity(value: ENTITY): VM

  fun toEntity(values: Collection<VM>): Collection<ENTITY> {
    val returnValues = ArrayList<ENTITY>(values.size)
    for (value in values) {
      if (value != null)
        returnValues.add(toEntity(value))
    }
    return returnValues
  }

  fun fromEntity(values: Collection<ENTITY>): Collection<VM> {
    val returnValues = ArrayList<VM>(values.size)
    for (value in values) {
      if (value != null)
        returnValues.add(fromEntity(value))
    }
    return returnValues
  }
}