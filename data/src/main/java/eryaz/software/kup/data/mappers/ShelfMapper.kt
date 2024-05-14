package eryaz.software.kup.data.mappers

import eryaz.software.kup.data.models.dto.ProductSpecialShelfDto
import eryaz.software.kup.data.models.dto.ShelfDto
import eryaz.software.kup.data.models.remote.response.ProductSpecialShelfResponse
import eryaz.software.kup.data.models.remote.response.ShelfResponse

fun ShelfResponse.toDto() = ShelfDto(
    shelfAddress = fullAddress,
    shelfId = shelfId,
    quantity = quantity.toInt().toString()
)

fun ProductSpecialShelfResponse.toDto() = ProductSpecialShelfDto(
    shelfDto = shelf?.toDto(),
    product = product.toDto(),
    quantity = quantity.toString()
)