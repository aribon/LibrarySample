package me.aribon.data_glose.repository.mapper

abstract class Mapper<out FROM, in TO> where FROM : Any, TO : Any {

  abstract fun map(value: TO): FROM

  fun map(values: Collection<TO>): Collection<FROM> {
    val returnValues = ArrayList<FROM>(values.size)
    for (value in values) {
      if (value != null)
        returnValues.add(map(value))
    }
    return returnValues
  }
}