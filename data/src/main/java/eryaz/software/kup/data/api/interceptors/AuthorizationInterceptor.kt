package eryaz.software.kup.data.api.interceptors

import eryaz.software.kup.data.persistence.SessionManager
import okhttp3.Interceptor
import okhttp3.Response

class AuthorizationInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
            .newBuilder()
            .addHeader("Content-Type", "application/json")
            .addHeader("Authorization", SessionManager.token)
            .build()
        return chain.proceed(request)
    }
}
