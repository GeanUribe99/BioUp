package pe.edu.idat.bioup

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import pe.edu.idat.bioup.auth.view.ReservarCitasScreen
import pe.edu.idat.bioup.auth.view.loginScreen
import pe.edu.idat.bioup.informationUser.mostrarInformation
import pe.edu.idat.bioup.ui.theme.BioUpTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BioUpTheme {
                //mostrarInformation()
                //loginScreen()
                //NavigationDrawer()
                //HistorialMedico()
                ReservarCitasScreen(context = this)
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BioUpTheme {

    }
}