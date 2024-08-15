package pe.edu.idat.bioup.auth.data.network.request

data class RegistroRequest (
    var dni: String,
    var fechaNacimiento: String, //date?
    var celular: String,
    var correo: String,
    var password: String
)