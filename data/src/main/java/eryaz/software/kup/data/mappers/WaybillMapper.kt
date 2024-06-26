package eryaz.software.kup.data.mappers

import eryaz.software.kup.data.models.dto.WaybillListDetailDto
import eryaz.software.kup.data.models.remote.response.WaybillListDetailResponse

fun WaybillListDetailResponse.toDto() = WaybillListDetailDto(
    product = product.toDto(),
    quantity = quantity,
    quantityOrder = quantityOrder,
    quantityPlaced = quantityPlaced,
    quantityControlled = quantityControlled.toString(),
    id = id
)