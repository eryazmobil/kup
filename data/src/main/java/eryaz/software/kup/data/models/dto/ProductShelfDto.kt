package eryaz.software.kup.data.models.dto

data class ProductShelfDto(
    val id: Int,
    val product: ProductDto,
    val shelf: ShelfDto,
    val safetyPercent: Int,
    val maxQuantity: Int,
    val quantity: Int
)
