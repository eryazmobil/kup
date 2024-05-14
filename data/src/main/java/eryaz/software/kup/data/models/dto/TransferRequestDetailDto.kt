package eryaz.software.kup.data.models.dto

data class TransferRequestDetailDto(
    val id: Int,
    val product: ProductDto,
    val quantity: String,
    val quantityPicked: String,
    val quantityShipped: String
)