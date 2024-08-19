package pe.edu.idat.bioup

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import pe.edu.idat.bioup.auth.view.loginScreen
import pe.edu.idat.bioup.auth.viewmodel.LoginViewModel
import pe.edu.idat.bioup.auth.viewmodel.RegistroViewModel
import pe.edu.idat.bioup.core.ruteo.Ruta
import pe.edu.idat.bioup.home.view.homeScreen
import pe.edu.idat.bioup.home.viewmodel.HomeViewModel
import pe.edu.idat.bioup.ui.theme.BioUpTheme
import pe.idat.apppatitas_compose.auth.view.registroScreen
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val loginViewModel: LoginViewModel by viewModels()
    private val registroViewModel: RegistroViewModel by viewModels()
    private val homeViewModel: HomeViewModel by viewModels()

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
                composable(Ruta.homeScreen.path){
                    homeScreen(homeViewModel, navigation)
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