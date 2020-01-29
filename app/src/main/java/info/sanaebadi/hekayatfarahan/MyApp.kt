package info.sanaebadi.hekayatfarahan

import android.app.Application
import info.sanaebadi.hekayatfarahan.di.myModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()

        //use koin and start it here
        startKoin {
            androidContext(this@MyApp)
            modules(myModule)
        }
    }
}