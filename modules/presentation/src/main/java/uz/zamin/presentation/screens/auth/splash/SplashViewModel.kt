package uz.zamin.presentation.screens.auth.splash

import kotlinx.coroutines.launch
import uz.zamin.core.base.BaseViewModel
import uz.zamin.core.base.EmptyIntent
import uz.zamin.core.base.EmptyState
import uz.zamin.domain.usecases.auth.AuthUseCase
import uz.zamin.presentation.screens.auth.splash.SplashScreenEvent.Auth

class SplashViewModel(private val authUseCase: AuthUseCase) :
    BaseViewModel<EmptyState, SplashScreenEvent, EmptyIntent>(EmptyState) {
    override fun onEvent(event: SplashScreenEvent) {
        when (event) {
            Auth -> launch { authUseCase.invoke() }
        }
    }
}