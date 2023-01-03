package uz.zamin.remote.api

import android.util.Log
import io.ktor.client.HttpClient
import io.ktor.client.request.post
import io.ktor.client.request.url
import io.ktor.client.statement.request
import io.ktor.http.ContentType
import io.ktor.http.contentType
import uz.zamin.remote.ApiPaths.authPath

class AuthApi(private val httpClient: HttpClient) {
    suspend fun loginPhone() {
        val respose = httpClient.post {
            contentType(ContentType.Application.Json)
            url(authPath)
        }
        Log.i("pppp", "loginPhone: ${respose.request.url}")
    }

}