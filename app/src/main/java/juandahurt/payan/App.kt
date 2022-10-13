package juandahurt.payan

import android.app.Application
import juandahurt.payan.core.network.NetworkManager

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        NetworkManager.getSharedInstance().provideBaseUrl("https://payan-dev.vercel.app")
    }
}