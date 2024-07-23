package pe.edu.idat.bioup.auth.view

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Key
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.Divider

import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pe.edu.idat.bioup.R


@Composable
fun loginScreen(){
    Scaffold {
        paddingInit ->
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(paddingInit)){
            cabeceraLogin(Modifier.align(Alignment.TopEnd))
            formularioLogin(Modifier.align(Alignment.Center))

        }
    }
}

@Composable
fun formularioLogin(modifier: Modifier){

    Column(modifier = modifier
        .padding(start = 5.dp, end = 5.dp)
        .padding(top = 70.dp)) {
        imagenLogo(modifier = Modifier.align(Alignment.CenterHorizontally))
        Spacer(modifier = Modifier.size(30.dp))
        txtusuario()
        Spacer(modifier = Modifier.size(16.dp))
        txtpassword()
        Spacer(modifier = Modifier.size(16.dp))
        loginButton()
        Spacer(modifier = Modifier.size(16.dp))
        loginGoogle()
        Spacer(modifier = Modifier.size(16.dp))
        registroLogin()

    }
}

@Composable
fun txtusuario() {
    OutlinedTextField(
        value = "",
        onValueChange = { },
        modifier = Modifier.fillMaxWidth(),
        label = { Text(text = "Usuario") },
        maxLines = 1,
        leadingIcon = { Icon(imageVector = Icons.Default.Person, contentDescription = "persona")},
        singleLine = true)
}
@Composable
fun txtpassword() {
    var visible by rememberSaveable {
        mutableStateOf(false)
    }
    OutlinedTextField(
        value = "",
        onValueChange = { },
        modifier = Modifier.fillMaxWidth(),
        label = { Text(text = "Password") },
        maxLines = 1,
        singleLine = true,
        leadingIcon = { Icon(imageVector = Icons.Default.Key, contentDescription = "persona")},
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        trailingIcon = {
            val icon = if(visible){
                Icons.Filled.VisibilityOff
            }else Icons.Filled.Visibility
            IconButton(onClick = { visible = !visible }) {
                Icon(imageVector = icon, contentDescription = "ver password")
            }
        },
        visualTransformation = if(visible){
            VisualTransformation.None
        } else PasswordVisualTransformation()
    )
}

@Composable
fun loginButton(){
    val scope = rememberCoroutineScope()
    Button(onClick = {},
        modifier = Modifier.fillMaxWidth())
    {
        Text(text = "INGRESAR")
    }
}

@Composable
fun loginGoogle(){
    Button(onClick = {},
        modifier = Modifier.fillMaxWidth())
    {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ){
            Image(
                painter = painterResource(id = R.drawable.googlelogo),
                contentDescription = "Google logo",
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "INGRESAR CON GOOGLE")
        }
    }
}

@Composable
fun imagenLogo(modifier: Modifier){
    Image(painter = painterResource(id = R.drawable.logo),
        contentDescription = "logo",
        modifier = modifier)
}

@Composable
fun cabeceraLogin(modifier: Modifier){
    val activity = LocalContext.current as Activity
    Icon(imageVector = Icons.Default.Close,
        contentDescription = "Cerrar",
        modifier = modifier.clickable { activity.finish() })
}


@Composable
fun registroLogin(){
    Row(Modifier.fillMaxSize(), horizontalArrangement =  Arrangement.Center) {
        Text(text = "¿No tienes cuenta?  ", fontSize = 12.sp, color = Color(0xFF21338D))
        Text(text = "  Registrate Aquí", fontSize = 12.sp, color = Color(0xFF21338D),
            modifier = Modifier.clickable {  },
            fontWeight = FontWeight.Bold)
    }
}

