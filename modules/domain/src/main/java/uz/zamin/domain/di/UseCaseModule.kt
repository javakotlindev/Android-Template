package uz.zamin.domain.di

import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import uz.zamin.domain.usecases.auth.AuthUseCase
import uz.zamin.domain.usecases.auth.AuthUseCaseImpl

val useCaseModule = module {
    singleOf(::AuthUseCaseImpl) { bind<AuthUseCase>() }
}