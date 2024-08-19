package pe.edu.idat.bioup.home.view
import androidx.compose.foundation.Image
import pe.edu.idat.bioup.R
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material.icons.filled.AddLocation
import androidx.compose.material.icons.filled.Checklist
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.LocalHospital
import androidx.compose.material.icons.filled.MedicalInformation
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Pets
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.launch
import pe.edu.idat.bioup.core.ruteo.Ruta
import pe.edu.idat.bioup.core.utils.MenuItem
import pe.edu.idat.bioup.home.viewmodel.HomeViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun homeScreen(homeViewModel: HomeViewModel,navPrincipal: NavController){

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val coroutineScope = rememberCoroutineScope()
    val navController = rememberNavController()

    ModalNavigationDrawer(drawerState = drawerState,
        drawerContent = {
            drawerContent(items = opcionesMenu(), onItemClick = { item ->
                coroutineScope.launch {
                    drawerState.close()
                }
                when (item.titulo) {
                    "Datos Basicos" -> navController.navigate(Ruta.personaldatesScreen.path)
                    "Datos Medicos" -> navController.navigate(Ruta.historiaclinicaScreen.path)
                    "Citas Medicas" -> navController.navigate(Ruta.reservarcitasScreen.path)
                    "Mapas" -> navController.navigate(Ruta.mapaScreen.path)
                }
            }, homeViewModel)
        },
        content = {
            Column {
                TopAppBar(colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.White,
                    titleContentColor = Color.Black
                ),
                    title = { Text(text = "Patitas APP") },
                    navigationIcon = {
                        IconButton(onClick = {
                            coroutineScope.launch {
                                drawerState.open()
                            }
                        }) {
                            Icon(Icons.Default.Menu, contentDescription = "Menu")
                        }
                    }, actions = {
                        IconButton(onClick = {
                            navPrincipal.navigate(Ruta.loginScreen.path){
                                popUpTo(navController.graph.startDestinationId)
                                { inclusive = true}
                            }
                        }) {
                            Icon(imageVector = Icons.AutoMirrored.Filled.ExitToApp, contentDescription = null,
                                tint = Color.Black)
                        }
                    })
                NavHost(navController = navController,
                    startDestination = Ruta.personaldatesScreen.path) {
                    composable(Ruta.historiaclinicaScreen.path){ historiaclinicaScreen(homeViewModel) }
                    composable(Ruta.historiadiariaScreen.path){ historiadiariaScreen(homeViewModel) } //voluntarioScreen(homeViewModel) }
                }
            }
        })
}

@Composable
fun drawerContent(
    items: List<MenuItem>,
    onItemClick: (MenuItem) -> Unit,
    homeViewModel: HomeViewModel
) {
    Column(
        Modifier
            .fillMaxSize()
            .background(Color.White)
            .systemBarsPadding()
    ) {
        cabeceraMenu(homeViewModel)
        Spacer(modifier = Modifier.height(8.dp))
        items.forEach { item ->
            drawerMenuItem(item, onItemClick)
        }
    }
}

@Composable
fun drawerMenuItem(item: MenuItem, onItemClick: (MenuItem) -> Unit) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .clickable { onItemClick(item) }
        .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically) {
        Icon(imageVector = item.icon, contentDescription = "")
        Spacer(modifier = Modifier.width(16.dp))
        Text(text = item.titulo)
    }
}

@Composable
fun cabeceraMenu(homeViewModel: HomeViewModel) {
    //val persona by homeViewModel.persona.observeAsState()
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        /*Image(
            painter = painterResource(id = R.drawable.imgperfil),
            contentDescription = "logo",
            modifier = Modifier
                .size(64.dp)
                .clip(CircleShape)
        )*/
        Spacer(modifier = Modifier.width(16.dp))
        Column {
            //persona?.let {
            //        value ->
            //    Text(text = value.nombres, fontWeight = FontWeight.Bold)
            //    Text(text = value.email, color = Color.Gray)
            Text(text = "paciente", fontWeight = FontWeight.Bold)
            Text(text = "id", color = Color.Gray)
            }

        }
}

fun opcionesMenu(): List<MenuItem> {
    return listOf(
        MenuItem(Icons.Default.Checklist, "Datos Basicos"),
        MenuItem(Icons.Default.MedicalInformation, "Datos Medicos"),
        MenuItem(Icons.Default.DateRange, "Citas Medicas"),
        MenuItem(Icons.Default.LocalHospital, "Mapas")

    )
}