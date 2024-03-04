package uz.tenderpro.domain.usecases.auth

import uz.tenderpro.domain.repositories.AuthRepository

class AuthUseCaseImpl(private val repository: AuthRepository) : AuthUseCase {
    override suspend fun invoke() {
        repository.loginPhone()
    }
}