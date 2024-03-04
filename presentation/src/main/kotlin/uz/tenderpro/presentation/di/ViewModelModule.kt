package uz.tenderpro.presentation.di

import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module
import uz.tenderpro.presentation.screens.auth.splash.SplashViewModel

val viewModelModule = module {
    viewModelOf(::SplashViewModel)
}
