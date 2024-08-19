package pe.edu.idat.bioup.mapa.view

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.MapUiSettings
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.rememberMarkerState

@Composable
fun GoogleMapsVista() {
    val mapProperties = MapProperties(isMyLocationEnabled = true)
    val mapUiSettings = MapUiSettings(zoomControlsEnabled = true)


    val marcadores = listOf(
        LatLng(-12.20865064985972, -76.93156601489825), // EsSalud VES
        LatLng(-12.160577817180423, -76.96918277945785), // EsSalud SJM
        LatLng(-12.147656173638186, -76.98428898012705), // Essalud Proceres Policlinico
        LatLng(-12.111072269161207, -77.0281354447252), // Essalud Angamos
        LatLng(-12.082537833552601, -77.02710547660057), // Lince
        LatLng(-12.054588185706647, -77.03059661462993), // Grau
        LatLng(-12.043655343478813, -76.99751034896924), // Agustino
        LatLng(-12.065250205800877, -77.09485993542273)


    )

    GoogleMap(
        modifier = Modifier.fillMaxSize(),
        properties = mapProperties,
        uiSettings = mapUiSettings
    ) {
        marcadores.forEach { latLng ->
            Marker(
                state = rememberMarkerState(position = latLng),
                title = "Marcador en ${latLng.latitude},${latLng.longitude}"
            )
        }
    }
}

@Composable
fun Contenedor (content: @Composable () -> Unit){
    MaterialTheme {
        Surface (modifier = Modifier.fillMaxSize()) {
            content()
        }
    }
}