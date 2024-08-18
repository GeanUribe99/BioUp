package pe.edu.idat.bioup

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import pe.edu.idat.bioup.auth.view.loginScreen
import pe.edu.idat.bioup.auth.viewmodel.LoginViewModel
import pe.edu.idat.bioup.auth.viewmodel.RegistroViewModel
import pe.edu.idat.bioup.core.ruteo.Ruta
import pe.edu.idat.bioup.informationUser.mostrarInformation
import pe.edu.idat.bioup.ui.theme.BioUpTheme
import pe.idat.apppatitas_compose.auth.view.registroScreen

class MainActivity : ComponentActivity() {

    private val loginViewModel: LoginViewModel by viewModels()
    private val registroViewModel: RegistroViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BioUpTheme {
             val navigation = rememberNavController()
            NavHost(navController = navigation, startDestination = Ruta.loginScreen.path,
            builder = {
               composable(Ruta.loginScreen.path){
                   loginScreen(loginViewModel, navigation)
                }
                  composable(Ruta.registroScreen.path){
                                   registroScreen(registroViewModel, navigation)
                 }


             })
                //val navigation = rememberNavController()
                //mostrarInformation()
                //loginScreen()
                //NavigationDrawer()
                //HistorialMedico()

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