package uz.zamin.data.di

import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import uz.zamin.data.repositories.AuthRepositoryImpl
import uz.zamin.domain.repositories.AuthRepository

val repositoryModule = module {
    singleOf(::AuthRepositoryImpl) { bind<AuthRepository>() }
}