package pe.edu.idat.bioup.home.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun EstadoCitaScreen(
    doctorName: String,
    especialidad: String,
    fecha: MutableState<String>,
    seleccionarHora: MutableState<String>,
    seleccionarTurno: MutableState<String>,
    selectedSede: MutableState<String>
) {
    //Estado de la cita (En Proceso o Finalizado)
    val estadoCita =
        remember { mutableStateOf("En Proceso") }//Cambiar según sea necesario por el momento

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        //Información del Dr
        Text(text = doctorName, fontWeight = FontWeight.Bold, fontSize = 24.sp)
        Text(text = especialidad, fontSize = 18.sp, color = Color.Gray)

        Spacer(modifier = Modifier.size(16.dp))

        //Información de Cita
        Text(text = "Fecha: ${fecha.value}", fontSize = 18.sp)
        Text(text = "Hora: ${seleccionarHora.value}", fontSize = 18.sp)
        Text(text = "Turno: ${seleccionarTurno.value}", fontSize = 18.sp)
        Text(text = "Sede: ${selectedSede.value}", fontSize = 18.sp)

        Spacer(modifier = Modifier.size(16.dp))

        //Estado de la cita
        Text(
            text = "Estado de la Cita: ${estadoCita.value}",
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            color = if (estadoCita.value == "En Proceso") Color.Green else Color.Red)

        Spacer(modifier = Modifier.size(16.dp))

        //Boton para cambiar el estado de la cita(simulacion)
        Button(onClick = {
            estadoCita.value = if (estadoCita.value == "En Proceso") "Finalizado" else "En Proceso"
        }){
            Text(text ="Cambiar Estado")
        }
    }
}