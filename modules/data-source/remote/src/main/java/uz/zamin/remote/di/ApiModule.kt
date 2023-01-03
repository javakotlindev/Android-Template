package uz.zamin.remote.di

import org.koin.dsl.module
import uz.zamin.remote.api.AuthApi

val apiModule = module {
    single { AuthApi(get()) }
}