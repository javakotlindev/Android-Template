package uz.zamin.data.repositories

import uz.zamin.domain.repositories.AuthRepository
import uz.zamin.remote.api.AuthApi

class AuthRepositoryImpl(private val authApi: AuthApi) : AuthRepository {
    override suspend fun loginPhone() {
        authApi.loginPhone()
    }
}