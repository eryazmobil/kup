package eryaz.software.kup.data.models.remote.response

import com.google.gson.annotations.SerializedName

data class CurrentLoginResponse(
    @SerializedName("user")
    val userInfo: CurrentUserResponse
)