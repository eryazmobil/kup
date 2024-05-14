package eryaz.software.kup.data.mappers

import eryaz.software.kup.data.models.dto.ClientDto
import eryaz.software.kup.data.models.remote.response.ClientSmallResponse

fun ClientSmallResponse.toDto() = ClientDto(
    id = id,
    code = code,
    name = name ?: "Hatalı işlem"
)