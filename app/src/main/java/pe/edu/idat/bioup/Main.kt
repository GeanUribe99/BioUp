package pe.edu.idat.bioup

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Place
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EjemploNavigationDrawer() {
    val opciones = listOf("Q&F", "Contacto Soporte", "T&C", "Cerrar sesion")
    val iconos = listOf(Icons.Filled.Face, Icons.Filled.Build, Icons.Filled.Info, Icons.Filled.ExitToApp)
    var opcionSeleccionada by remember {
        mutableStateOf(opciones[0])
    }
    val scope = rememberCoroutineScope()
    val estado = rememberDrawerState(initialValue = DrawerValue.Closed)
    ModalNavigationDrawer(
        modifier = Modifier.fillMaxSize(),
        drawerState = estado,
        drawerContent = {
            Column(
                Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(0.87f) // aqui se reemplazo el .fillMaxSize(), por ancho y alto para manejar el ancho ya que sobrepasa la aplicacion
                    .background(Color.White)
                    .systemBarsPadding()
            ) {
                opciones.forEachIndexed { index, opcion ->
                    NavigationDrawerItem(
                        icon = { Icon(imageVector = iconos[index], contentDescription = "") },
                        label = { Text(text = opcion) },
                        colors = NavigationDrawerItemDefaults.colors(
                            selectedContainerColor = Color.LightGray
                        ),
                        selected = opcion == opcionSeleccionada,
                        onClick = {
                            opcionSeleccionada = opcion
                            scope.launch {
                                estado.close()
                            }
                        },
                        modifier = Modifier
                            .padding(NavigationDrawerItemDefaults.ItemPadding)
                            .clip(RectangleShape)
                    )
                }

            }
        }) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text(text = "BioUp") },
                    navigationIcon = {
                        IconButton(onClick = {
                            scope.launch {
                                if (estado.isClosed) {
                                    estado.open()
                                } else {
                                    estado.close()
                                }
                            }
                        }) {
                            Icon(
                                imageVector = Icons.Filled.Menu,
                                contentDescription = ""
                            )
                        }
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = Color.Blue,
                        titleContentColor = Color.White
                    )
                )
            },
            bottomBar = { EjemploBottomBar()},
            content = { initialPadding ->
                Box(modifier = Modifier.padding(initialPadding))
            }
        )
    }
}


@Composable
fun EjemploScaffold() {
    var estado = remember {
        SnackbarHostState()
    }
    val scope = rememberCoroutineScope()
    Scaffold(
        topBar = { EjemploToolBar() },
        bottomBar = { EjemploBottomBar() },
        snackbarHost = {
            SnackbarHost(hostState = estado)
        },
        content = { initialpadding ->
            Box(
                modifier = Modifier
                    .padding(initialpadding)
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Button(onClick = {
                    scope.launch {
                        estado.showSnackbar(
                            "Hola clikeaste aqui!!",
                            actionLabel = "OK",
                            duration = SnackbarDuration.Long
                        )
                    }
                }) {
                    Text(text = "Mostrar SnackBar!")
                }
            }
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EjemploToolBar() {
    TopAppBar(
        title = { Text(text = "BioUp") },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Blue,
            titleContentColor = Color.White
        ),
        navigationIcon = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Filled.Menu,
                    contentDescription = "",
                    tint = Color.White
                )
            }
        },
        actions = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Filled.Call, contentDescription = "",
                    tint = Color.White
                )
            }
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Filled.Add, contentDescription = "",
                    tint = Color.White
                )
            }
        }

    )
}

@Composable
fun EjemploBottomBar() {
    val opciones = listOf("Home", "Centros", "Contactos", "Clave")
    val iconos  = listOf(Icons.Filled.Home, Icons.Filled.Place, Icons.Filled.AccountBox, Icons.Filled.Lock)
    var opcionSeleccionada by remember {
        mutableStateOf(0)
    }
    BottomAppBar(
        containerColor = Color.Blue,
        contentColor = Color.White,
        tonalElevation = 5.dp
    ) {
        opciones.forEachIndexed { index, opcion ->
            NavigationBarItem(selected = opcionSeleccionada == index,
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color.Black,
                    indicatorColor = Color.White,
                    unselectedIconColor = Color.White
                ),
                onClick = { opcionSeleccionada = index },
                icon = {
                    Icon(imageVector = iconos[index], contentDescription = "")
                },
                label = { Text(text = opcion, color = Color.White) })
        }
    }
}