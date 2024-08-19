package pe.edu.idat.bioup.core.ruteo

sealed class Ruta(val path: String) {
    object loginScreen : Ruta("loginScreen")
    object homeScreen : Ruta("homeScreen")
        fun paramMain(dni: String) = "homeScreen/$dni"
    object registroScreen : Ruta("RegistroScreen")

    object mapaScreen : Ruta("MapaScreen")
    object citasScreen : Ruta("citasScreen")
    object historiaclinicaScreen : Ruta("historiaclinicaScreen")
    object historiadiariaScreen : Ruta("historiadiariaScreen")
    object personaldatesScreen : Ruta("personaldatesScreen")
    object reservarcitasScreen : Ruta("reservarcitasScreen")

    //agregar screens!!!!
}