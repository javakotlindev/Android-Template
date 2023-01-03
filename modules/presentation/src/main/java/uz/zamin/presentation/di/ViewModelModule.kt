package uz.zamin.presentation.di

import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module
import uz.zamin.presentation.screens.auth.splash.SplashViewModel

val viewModelModule = module {
    viewModelOf(::SplashViewModel)
}