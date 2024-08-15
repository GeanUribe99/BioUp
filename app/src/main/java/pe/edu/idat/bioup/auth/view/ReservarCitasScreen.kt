package pe.edu.idat.bioup.auth.view

import android.content.Context
import android.icu.util.Calendar
import android.widget.DatePicker
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pe.edu.idat.bioup.R

@Composable
fun ReservarCitasScreen(context: Context) {
    val doctorName = "Dr. Juan Pérez"
    val especialidad = "Cardiología"
    val fecha = remember {
        mutableStateOf("")
    }
    val seleccionarTurno = remember {
        mutableStateOf("")
    }
    val turnoMañana = listOf("9:00 AM", "10:00 AM", "11:00 AM")

    val turnoTarde = listOf("14:00 PM", "15:00 PM", "16:00 PM")

    val seleccionarHora = remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        //Información del Doctor
        Text(text = doctorName, fontWeight = FontWeight.Bold, fontSize = 24.sp)
        Text(text = especialidad, fontSize = 18.sp, color = Color.Gray)

        Spacer(modifier = Modifier.size(16.dp))

        //Calendario
        Button(onClick = { mostrarSelectorFecha(context, fecha ) }) {
            Text(text = if (fecha.value.isNotEmpty()) fecha.value else "Seleccionar Fecha")
        }

        Spacer(modifier = Modifier.size(16.dp))

        //Seleccion de Turno
        Text(text = "Seleccionar Turno", fontWeight = FontWeight.Bold, fontSize = 18.sp)
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(onClick = { seleccionarTurno.value = "Mañana" }) {
                Text(text = "Mañana")
            }
            Button(onClick = { seleccionarTurno.value = "Tarde" }) {
                Text(text = "Tarde")
            }
        }

        Spacer(modifier = Modifier.size(16.dp))

        //Seleccionar Tiempo
        Text(text = "Seleccionar la Hora", fontWeight = FontWeight.Bold, fontSize = 18.sp)
        if (seleccionarTurno.value == "Mañana") {
            OpcionesTiempo(turnoMañana, seleccionarHora)
        } else if (seleccionarTurno.value == "Tarde") {
            OpcionesTiempo(turnoTarde, seleccionarHora)
        }

        Spacer(modifier = Modifier.size(16.dp))

        //Boton de Reservar
        Button(onClick = { /*TODO*/ }) {
            Text(text = "Resevar Cita")
        }
    }
}

@Composable
fun OpcionesTiempo(times: List<String>, seleccionarHora: MutableState<String>) {
    Column {
        times.forEach { time ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = time)
                IconButton(onClick = { seleccionarHora.value = time }) {
                    Icon(
                        painter = if (seleccionarHora.value == time)
                            painterResource(R.drawable.ic_check) else painterResource(R.drawable.ic_uncheck),
                        contentDescription = null
                    )
                }
            }
        }
    }
}

fun mostrarSelectorFecha(context: Context, date: MutableState<String>) {
    val calendar = Calendar.getInstance()
    val seleccionarFecha = android.app.DatePickerDialog(
        context,
        { _: DatePicker, year: Int, month: Int, dayOfMonth: Int ->
            date.value = "$dayOfMonth/${month + 1}/$year"
        },
        calendar.get(Calendar.YEAR),
        calendar.get(Calendar.MONTH),
        calendar.get(Calendar.DAY_OF_MONTH)
    )
    seleccionarFecha.show()
}
