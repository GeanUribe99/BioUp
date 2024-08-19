package pe.edu.idat.bioup.core.bd

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface PacienteDao {
    @Query("SELECT * FROM paciente WHERE DNI = :dni")
    fun getPacientebyDNI(dni: String): Flow<PacienteEntity>


}