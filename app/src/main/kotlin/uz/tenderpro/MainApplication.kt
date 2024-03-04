package uz.tenderpro

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin
import uz.tenderpro.data.di.repositoryModule
import uz.tenderpro.domain.di.useCaseModule
import uz.tenderpro.presentation.di.viewModelModule
import uz.tenderpro.remote.di.apiModule
import uz.tenderpro.remote.di.networkModule

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MainApplication)
            modules(repositoryModule, networkModule, apiModule, useCaseModule, viewModelModule)
        }
    }
}
