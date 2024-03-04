package ${packageName}.${packagePath}

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import cafe.adriel.voyager.androidx.AndroidScreen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import org.koin.androidx.compose.koinViewModel
import uz.zamin.coreui.ui.SBTheme

class ${uiName}: AndroidScreen() {

@Composable
override fun Content() {
val viewModel = koinViewModel<${componentName}ViewModel>()
val uiState by viewModel.uiState.collectAsStateWithLifecycle()
val navigator = LocalNavigator.currentOrThrow
${uiName}Content(uiState = uiState)
}

@Composable
internal fun ${uiName}Content(uiState: ${componentName}State) {
Scaffold() { paddings->
Box(modifier = Modifier.padding(paddings))
}
}
 }

@Preview(showSystemUi = true)
@Composable
private fun Preview() {
    SBTheme {
       ${uiName}().${uiName}Content(uiState = ${componentName}State())
    }
}
