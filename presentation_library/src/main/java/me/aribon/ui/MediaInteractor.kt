package me.aribon.ui

/**
 * Created by anthony.ribon
 * On 20/03/2019
 */
sealed class MediaInteractor {
  class CategoryListInteractor(): MediaInteractor()
  class MediaListIntearctor(): MediaInteractor()
  class MediaDetailsInteractor(): MediaInteractor()
}