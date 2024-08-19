package pe.edu.idat.bioup.core.bd

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [PacienteEntity::class], version = 1)
abstract class BioupDatabase: RoomDatabase(){
    abstract fun pacienteDao(): PacienteDao
}