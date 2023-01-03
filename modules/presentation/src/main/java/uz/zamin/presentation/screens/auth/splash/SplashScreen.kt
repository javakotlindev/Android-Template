package uz.zamin.presentation.screens.auth.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.core.screen.uniqueScreenKey
import org.koin.androidx.compose.koinViewModel
import uz.zamin.presentation.R
import uz.zamin.presentation.screens.auth.splash.SplashScreenEvent.Auth

class SplashScreen : Screen {
    override val key = uniqueScreenKey


    @Composable
    override fun Content() {
        val viewModel = koinViewModel<SplashViewModel>()
        viewModel.sendEvent(Auth)
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Image(
                painter = painterResource(R.drawable.ic_android_black),
                contentDescription = null,
            )
        }
    }
}