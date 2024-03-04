package uz.tenderpro.presentation.screens.auth.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.core.screen.uniqueScreenKey
import org.koin.androidx.compose.koinViewModel
import uz.tenderpro.presentation.R
import uz.tenderpro.presentation.ui.TenderProTheme

class SplashScreen : Screen {
    override val key = uniqueScreenKey

    @Composable
    override fun Content() {
        val viewModel = koinViewModel<SplashViewModel>()
        SplashScreenContent()
    }

    @Composable
    internal fun SplashScreenContent() {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Image(
                painter = painterResource(R.drawable.ic_android_black),
                contentDescription = null,
            )
        }
    }
}

@Preview
@Composable
private fun PreviewSplashContent() {
    TenderProTheme {
        SplashScreen().SplashScreenContent()
    }
}
