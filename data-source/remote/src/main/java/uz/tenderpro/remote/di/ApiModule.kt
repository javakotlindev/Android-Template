package uz.tenderpro.remote.di

import org.koin.dsl.module
import uz.tenderpro.remote.api.AuthApi

val apiModule = module {
    single { AuthApi(get()) }
}