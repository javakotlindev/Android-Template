package ${packageName}.${packagePath}

import uz.zamin.core.base.BaseViewModel

class ${componentName}ViewModel(
) : BaseViewModel<${componentName}State, ${componentName}Event, ${componentName}SideEffect>(${componentName}State()) {

 override fun onEvent(intent: ${componentName}Event) = Unit
}
