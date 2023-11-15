package com.luigidev.themvpcrud

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import net.sqlcipher.database.SQLiteDatabase

@HiltAndroidApp
class CRUDApplication() : Application() {
    override fun onCreate() {
        super.onCreate()
        SQLiteDatabase.loadLibs(this)
//      database.close()
    }
}
