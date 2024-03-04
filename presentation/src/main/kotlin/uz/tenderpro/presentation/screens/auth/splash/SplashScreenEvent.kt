package uz.tenderpro.presentation.screens.auth.splash

sealed class SplashScreenEvent {
    data object Auth: SplashScreenEvent()
}
