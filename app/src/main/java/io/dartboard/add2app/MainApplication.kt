package io.dartboard.add2app

import android.app.Application
import io.dartboard.dart_board_core_plugin.DartBoardCorePlugin

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        DartBoardCorePlugin.warmup(this)
    }
}