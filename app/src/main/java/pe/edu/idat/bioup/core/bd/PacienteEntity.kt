package pe.edu.idat.bioup.core.bd

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "paciente")

data class PacienteEntity(
    @PrimaryKey
    val id: Int,
    val DNI: String,
    val Sexo: String,
    val Correo: String,
    val NombrePx: String,
    val Password: String,
    val Direccion: String,
    val Numerocel: String,
    val Nacionalidad: String,
    val FechaNacimiento: String,
    val ContactoEmergencia: String,
)



