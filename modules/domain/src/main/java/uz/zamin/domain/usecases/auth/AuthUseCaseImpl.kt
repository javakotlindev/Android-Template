package uz.zamin.domain.usecases.auth

import uz.zamin.domain.repositories.AuthRepository

class AuthUseCaseImpl(private val repository: AuthRepository) : AuthUseCase {
    override suspend fun invoke() {
        repository.loginPhone()
    }
}