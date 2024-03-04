package uz.tenderpro.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.view.WindowCompat
import cafe.adriel.voyager.navigator.Navigator
import uz.tenderpro.presentation.screens.auth.splash.SplashScreen
import uz.tenderpro.presentation.ui.TenderProTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            TenderProTheme {
                Navigator(screen = SplashScreen())
            }
        }
    }
}
