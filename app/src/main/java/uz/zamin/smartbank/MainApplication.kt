package uz.zamin.smartbank

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin
import uz.zamin.data.di.repositoryModule
import uz.zamin.domain.di.useCaseModule
import uz.zamin.presentation.di.viewModelModule
import uz.zamin.remote.di.apiModule
import uz.zamin.remote.di.networkModule

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MainApplication)
            modules(repositoryModule, networkModule, apiModule, useCaseModule, viewModelModule)
        }
    }
}