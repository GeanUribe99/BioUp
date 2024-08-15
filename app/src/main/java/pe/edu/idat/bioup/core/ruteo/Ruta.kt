package pe.edu.idat.bioup.core.ruteo

sealed class Ruta(val path: String) {
    object loginScreen : Ruta("loginScreen")
    object mainScreen : Ruta("Main")
    object registroScreen : Ruta("RegistroScreen")
    //agregar screens!!!!
}