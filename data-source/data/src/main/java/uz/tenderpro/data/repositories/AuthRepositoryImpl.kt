package uz.tenderpro.data.repositories

import uz.tenderpro.domain.repositories.AuthRepository
import uz.tenderpro.remote.api.AuthApi

class AuthRepositoryImpl(private val authApi: AuthApi) : AuthRepository {
    override suspend fun loginPhone() {
        authApi.loginPhone()
    }
}