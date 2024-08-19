package pe.edu.idat.bioup

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material3.Icon

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

import androidx.lifecycle.viewmodel.compose.viewModel
import pe.edu.idat.bioup.informationUser.fotoComponent
@Composable
fun UserScreen(userId: String, viewModel: UsuarioViewModel = viewModel()) {

    LaunchedEffect(userId) {
        viewModel.loadUser(userId)
    }

    val user by viewModel.user.collectAsState()
    val error by viewModel.error.collectAsState()

    // Aquí defino mis variables solo si `user` no es nulo
    val idPaciente = user?.id.orEmpty()
    val paciente = "Jair Fernandez Castillo"
    val dni = "78965412"
    val idHc = 1234
    val sexo = "Masculino"
    val edad = user?.edad.orEmpty()
    val direccion = user?.direccion.orEmpty()
    val celular = user?.numero.orEmpty()
    val numContacto = "1111"
    val nacionalidad = "Chamo"

    Box(modifier = Modifier
        .fillMaxSize()
        .padding(start = 25.dp, end = 25.dp, bottom = 30.dp, top = 60.dp)) {

        Column(modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())) {

            Row {
                Text(text = "Información Personal")
            }

            Row(modifier = Modifier.padding(bottom = 15.dp, top = 10.dp)) {
                Column {
                    fotoComponent()
                }
                Column {
                    Row {
                        Text(text = "Id Paciente")
                        Spacer(modifier = Modifier.width(2.dp))
                        Text(text = idPaciente)
                    }
                    Row {
                        Text(text = "DNI")
                        Spacer(modifier = Modifier.width(2.dp))
                        Text(text = dni)
                    }
                }
            }

            /////// EL RESTO DE FILAS

            Row(modifier = Modifier.padding(bottom = 15.dp, top = 10.dp)) {
                Column {
                    Row { Text(text = "Nombre y Apellidos") }
                    Row { Text(text = paciente) }
                }
            }
            Row(modifier = Modifier.padding(bottom = 15.dp, top = 10.dp)) {
                Column {
                    Row { Text(text = "Edad") }
                    Row { Text(text = edad) }
                }
            }
            Row(modifier = Modifier.padding(bottom = 15.dp, top = 10.dp)) {
                Column {
                    Row { Text(text = "Nacionalidad") }
                    Row { Text(text = nacionalidad) }
                }
            }
            Row(modifier = Modifier.padding(bottom = 15.dp, top = 10.dp)) {
                Column {
                    Row { Text(text = "Sexo") }
                    Row { Text(text = sexo) }
                }
            }
            Row(modifier = Modifier.padding(bottom = 15.dp, top = 10.dp)) {
                Column {
                    Row { Text(text = "Dirección") }
                    Row { Text(text = direccion) }
                }
            }
            Row(modifier = Modifier.padding(bottom = 15.dp, top = 10.dp)) {
                Column {
                    Row { Text(text = "Celular") }
                    Row { Text(text = celular) }
                }
            }
            Row(modifier = Modifier.padding(bottom = 15.dp, top = 10.dp)) {
                Column {
                    Row { Text(text = "Contacto de Emergencia") }
                    Row { Text(text = numContacto) }
                }
            }
        }
    }
}

@Composable
fun fotoComponent() {
    Box(
        modifier = Modifier
            .fillMaxWidth(0.6f)
            .height(120.dp)
            .border(width = 2.dp, color = Color.Black)
    ) {
        Icon(
            imageVector = Icons.Filled.CameraAlt,
            contentDescription = "Icono de cámara",
            modifier = Modifier
                .fillMaxSize()
        )
    }
}
