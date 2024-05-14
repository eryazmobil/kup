package eryaz.software.kup.data.mappers

import eryaz.software.kup.data.models.dto.ErrorDto
import eryaz.software.kup.data.models.remote.response.ErrorModel

fun ErrorModel.toDto() = ErrorDto(
    code = code,
    message = message
)