package me.aribon.library.data.provider.network

import com.google.gson.annotations.SerializedName

/**
 * @Author: aribon
 * @Date: 06/03/2019
 */
sealed class Response {

  data class CategoryResponse(
      @SerializedName("id")
      val id: String,
      @SerializedName("slug")
      val slug: String,
      @SerializedName("title")
      val label: String
                             ) : Response()

  data class AuthorResponse(

      @SerializedName("id")
      val id: String,
      @SerializedName("name")
      val name: String,
      @SerializedName("slug")
      val label: String
                           ) : Response()

  data class PriceResponse(
      @SerializedName("amount")
      val amount: Number,
      @SerializedName("currency")
      val currency: String,
      @SerializedName("included_taxes")
      val includedTaxes: Boolean
                          ) : Response()

  data class BookResponse(
      @SerializedName("id")
      val id: String,
      @SerializedName("authors")
      val authors: Collection<AuthorResponse>,
      @SerializedName("short_title")
      val shortTitle: String,
      @SerializedName("title")
      val title: String,
      @SerializedName("price")
      val price: PriceResponse?,
      @SerializedName("description")
      val description: String,
      @SerializedName("publisher")
      val publisher: String,
      @SerializedName("image")
      val image: String
                         ) : Response()
}