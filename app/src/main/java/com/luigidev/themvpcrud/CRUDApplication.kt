package com.luigidev.themvpcrud

import android.app.Application
import net.sqlcipher.database.SQLiteDatabase


class CRUDApplication() : Application() {
    override fun onCreate() {
        super.onCreate()
        SQLiteDatabase.loadLibs(this)
//        // Example: Create or open the encrypted database in the DatabaseHelper class
//        val databaseHelper = DatabaseHelper(this)
//        val database = databaseHelper.writableDatabase(passphrase)
//
//        // Perform any database initialization or creation logic
//        // For example, you might create tables or perform schema migrations here
//
//        // Close the database to release resources
//        database.close()
    }
}