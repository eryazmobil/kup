package eryaz.software.kup.data.repositories

import eryaz.software.kup.data.api.utils.ResponseHandler
import eryaz.software.kup.data.api.services.AuthApiService
import eryaz.software.kup.data.models.remote.request.LoginRequest

class AuthRepo(private val api: AuthApiService) : BaseRepo() {

    suspend fun login(request: LoginRequest) = callApi {
        val response = api.login(request)
        //dto modeli 2ci responseda handle yap
        ResponseHandler.handleSuccess(response, response.result)
    }

    suspend fun getPdaVersion() = callApi {
        val response = api.getPdaVersion()
        ResponseHandler.handleSuccess(response, response.result)
    }

}