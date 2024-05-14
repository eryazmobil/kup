package eryaz.software.kup.data.mappers

import eryaz.software.kup.data.models.dto.BarcodeDto
import eryaz.software.kup.data.models.remote.response.BarcodeResponse

fun BarcodeResponse.toDto() = BarcodeDto(
    id = id,
    product = product.toDto(),
    code = code,
    quantity = quantity
)