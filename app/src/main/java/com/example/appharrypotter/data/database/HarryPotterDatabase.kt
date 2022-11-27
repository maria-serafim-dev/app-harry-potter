package com.example.appharrypotter.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.appharrypotter.data.database.converters.Converters
import com.example.appharrypotter.data.database.dao.CharacterDao
import com.example.appharrypotter.data.model.database.CharacterEntity

@Database(entities = [CharacterEntity::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class HarryPotterDatabase : RoomDatabase() {

    abstract fun characterDao() : CharacterDao

    companion object{
        @Volatile
        private var INSTANCE: HarryPotterDatabase? = null

        fun getDatabase(context: Context): HarryPotterDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context,
                    HarryPotterDatabase::class.java,
                    "db_harry_potter")
                    .build()
                INSTANCE = instance

                instance
            }
        }
    }
}