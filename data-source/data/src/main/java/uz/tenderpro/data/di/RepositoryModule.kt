package uz.tenderpro.data.di

import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import uz.tenderpro.data.repositories.AuthRepositoryImpl
import uz.tenderpro.domain.repositories.AuthRepository

val repositoryModule = module {
    singleOf(::AuthRepositoryImpl) { bind<AuthRepository>() }
}