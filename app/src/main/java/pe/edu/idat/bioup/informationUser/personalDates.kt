package pe.edu.idat.bioup.informationUser

import android.graphics.ColorFilter
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Camera
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.PointerIcon.Companion.Text
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.SemanticsProperties.Text
import androidx.compose.ui.text.input.KeyboardType.Companion.Text
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import pe.edu.idat.bioup.R
import pe.edu.idat.bioup.auth.view.cabeceraLogin
import pe.edu.idat.bioup.auth.view.formularioLogin
import pe.edu.idat.bioup.auth.view.imagenLogo
import pe.edu.idat.bioup.auth.view.loginButton
import pe.edu.idat.bioup.auth.view.loginGoogle
import pe.edu.idat.bioup.auth.view.registroLogin
import pe.edu.idat.bioup.auth.view.txtpassword
import pe.edu.idat.bioup.auth.view.txtusuario



@Composable
fun mostrarInformation(){

    //Aqui defino mis variables traidas con un cierto IdPaciente
    var idPaciente = 3246
    var paciente = "Jair Fernandez Castillo"
    var dni = "78965412"
    var idHc = 1234
    var sexo = "Masculino"
    var edad = 25
    var direccion = "xxxxxxxx"
    var celular = "1111"
    var numContacto = "1111"
    var nacionalidad = "Chamo"

    Box(modifier = Modifier
        .fillMaxSize()
        .padding(start = 25.dp, end = 25.dp, bottom = 30.dp, top = 60.dp)){

        Column(modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())) {
            Row {
                Text(text = "Informacion Personal")
            }

            Row (modifier = Modifier.padding(bottom = 15.dp, top = 10.dp)){
                Column {
                    fotoComponent()
                }
                Column {
                    Row {
                        Text(text = "Id Paciente")
                        Spacer(modifier = Modifier.width(2.dp))
                        Text(text = "$idPaciente")
                    }
                    Row {
                        Text(text = "Dni")
                        Spacer(modifier = Modifier.width(2.dp))
                        Text(text = "$dni")
                    }
                }

            }

            ///////EL RESTO DE FILAS

            Row (modifier = Modifier.padding(bottom = 15.dp, top = 10.dp)){
                Column {
                    Row {Text(text = "Nombre y Apellidos")}
                    Row {Text(text = "$paciente")}
                }
            }
            Row (modifier = Modifier.padding(bottom = 15.dp, top = 10.dp)){
                Column {
                    Row{Text(text = "Edad")}
                    Row{Text(text = "$edad")}
                }
            }
            Row (modifier = Modifier.padding(bottom = 15.dp, top = 10.dp)){
                Column {
                    Row {Text(text = "Nacionalidad")}
                    Row {Text(text = "$nacionalidad")}
                }
            }
            Row (modifier = Modifier.padding(bottom = 15.dp, top = 10.dp)){
                Column {
                    Row{Text(text = "Sexo")}
                    Row{Text(text = "$sexo")}
                }
            }
            Row (modifier = Modifier.padding(bottom = 15.dp, top = 10.dp)){
                Column {
                    Row {Text(text = "Direccion")}
                    Row {Text(text = "$direccion")}
                }
            }
            Row (modifier = Modifier.padding(bottom = 15.dp, top = 10.dp)){
                Column {
                    Row{Text(text = "Celular")}
                    Row{Text(text = "$celular")}
                }
            }
            Row (modifier = Modifier.padding(bottom = 15.dp, top = 10.dp)){
                Column {
                    Row{Text(text = "Contacto de Emergencia")}
                    Row{Text(text = "$numContacto")}
                }
            }
        }
    }

}

@Composable
fun fotoComponent(){
    Box(
        modifier = Modifier
            .fillMaxWidth(0.6f)
            .height(120.dp)
            .border(width = 2.dp, color = Color.Black)
    ){
        Icon(
            imageVector = Icons.Filled.CameraAlt,
            contentDescription = "Icono de cámara",
            modifier = Modifier
                .fillMaxSize()
        )
    }
}
