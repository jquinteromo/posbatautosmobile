package com.example.myapplication

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

//creamos una base de datos y la tabla junto a sus columnas
class SqliteDTB(context: Context) : SQLiteOpenHelper(context, "posbatautosmobile.db", null, 1) {
    override fun onCreate(db: SQLiteDatabase) {
        val createTable = "CREATE TABLE Persona" +
                " (idPersona INTEGER PRIMARY KEY AUTOINCREMENT,  " +
                "Email TEXT, Password TEXT)"

        db.execSQL(createTable)
    }

    //actualizamos la  tabla cada vez que se inserten nuevos datos
    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        val UpdateTable = "DROP TABLE IF EXISTS Persona"
        db.execSQL(UpdateTable)
        onCreate(db)
    }

//creamos una fucnion que inserta los datos
    fun insertarDatos(Email: String, Password: String): Long {
        val datos = ContentValues().apply {
            put("Email", Email)
            put("Password", Password)
        }

        val db = this.writableDatabase
        val result = db.insert("Persona", null, datos)
        db.close()
        return result
    }
}