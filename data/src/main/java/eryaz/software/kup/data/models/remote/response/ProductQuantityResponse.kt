package eryaz.software.kup.data.models.remote.response

import com.google.gson.annotations.SerializedName
import eryaz.software.kup.data.models.dto.ProductDto

data class ProductQuantityResponse(
    @SerializedName("product")
    val product: ProductDto,
    @SerializedName("quantity")
    val quantity: Int
)