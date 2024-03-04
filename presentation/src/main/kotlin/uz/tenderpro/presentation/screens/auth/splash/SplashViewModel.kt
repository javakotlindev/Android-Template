package uz.tenderpro.presentation.screens.auth.splash

import kotlinx.coroutines.launch
import uz.tenderpro.presentation.core.viewmodel.BaseViewModel
import uz.tenderpro.presentation.core.viewmodel.EmptyIntent
import uz.tenderpro.presentation.core.viewmodel.EmptyState
import uz.tenderpro.domain.usecases.auth.AuthUseCase
import uz.tenderpro.presentation.screens.auth.splash.SplashScreenEvent.Auth

class SplashViewModel(private val authUseCase: AuthUseCase) :
    BaseViewModel<EmptyState, SplashScreenEvent, EmptyIntent>(EmptyState) {
    override fun onEvent(event: SplashScreenEvent) {
        when (event) {
            Auth -> launch { authUseCase() }
        }
    }
}
