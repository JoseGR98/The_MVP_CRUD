package com.luigidev.themvpcrud.core

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import com.luigidev.themvpcrud.features.home.domain.models.Product
import net.sqlcipher.database.SQLiteDatabase
import net.sqlcipher.database.SQLiteOpenHelper


class DatabaseHelper(context: Context) :
    SQLiteOpenHelper(context, "encrypted_database.db", null, 1) {

    companion object {
        private const val TABLE_NAME = "products"
        private const val COLUMN_ID = "id"
        private const val COLUMN_NAME = "name"
        private const val COLUMN_DESCRIPTION = "description"
        private const val COLUMN_PRICE = "price"
    }

    init {
        SQLiteDatabase.loadLibs(context)
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val createTableQuery =
            "CREATE TABLE IF NOT EXISTS $TABLE_NAME ($COLUMN_ID INTEGER PRIMARY KEY, $COLUMN_NAME TEXT, $COLUMN_DESCRIPTION TEXT, $COLUMN_PRICE INTEGER)"
        db?.execSQL(createTableQuery)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        // Handle database schema upgrades
    }

    fun insertProduct(product: Product): ResultDatabase {
        val contentValues = ContentValues().apply {
            put(COLUMN_NAME, product.name)
            put(COLUMN_DESCRIPTION, product.description)
            put(COLUMN_PRICE, product.price)
        }

        val writableDatabase = getWritableDatabase("your_secret_passphrase")
        val insertedProductId = writableDatabase.insert(TABLE_NAME, null, contentValues)
        writableDatabase.close()
        return ResultDatabase.Success(insertedProductId.toString())
    }

    @SuppressLint("Range")
    fun getProducts(): List<Product> {
        val products = mutableListOf<Product>()
        val query = "SELECT * FROM $TABLE_NAME"

        val readableDatabase =
            getReadableDatabase("your_secret_passphrase")
        val cursor: net.sqlcipher.Cursor = readableDatabase.rawQuery(query, null)

        while (cursor.moveToNext()) {
            val id = cursor.getInt(cursor.getColumnIndex(COLUMN_ID))
            val name = cursor.getString(cursor.getColumnIndex(COLUMN_NAME))
            val description = cursor.getString(cursor.getColumnIndex(COLUMN_DESCRIPTION))
            val price = cursor.getInt(cursor.getColumnIndex(COLUMN_PRICE))

            val product = Product(id, name, description, price)
            products.add(product)
        }

        cursor.close()
        readableDatabase.close()
        return products
    }

    fun deleteDatabase(context: Context) {
        context.deleteDatabase("encrypted_database.db")
    }
}