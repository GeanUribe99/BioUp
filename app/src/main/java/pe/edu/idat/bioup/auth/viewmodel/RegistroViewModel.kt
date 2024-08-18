package pe.edu.idat.bioup.auth.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import pe.edu.idat.bioup.auth.data.network.request.RegistroRequest
import pe.edu.idat.bioup.auth.data.network.response.RegistroResponse
import pe.edu.idat.bioup.auth.domain.LoginUseCase
import pe.edu.idat.bioup.auth.domain.RegistroUseCase
import pe.edu.idat.bioup.core.utils.Event
import javax.inject.Inject


@HiltViewModel
class RegistroViewModel @Inject constructor(
    private val registroUseCase: RegistroUseCase) : ViewModel() {

    private val _dni = MutableLiveData<String>()
    val dni: LiveData<String> = _dni
    private val _fechaNacimiento = MutableLiveData<String>()
    val fechaNacimiento: LiveData<String> = _fechaNacimiento
    private val _celular = MutableLiveData<String>()
    val celular: LiveData<String> = _celular
    private val _correo = MutableLiveData<String>()
    val correo: LiveData<String> = _correo
    private val _password = MutableLiveData<String>()
    val password: LiveData<String> = _password
    private val _registroResponse = MutableLiveData<Event<RegistroResponse>>()
    val registroResponse: LiveData<Event<RegistroResponse>> = _registroResponse

    fun onRegistroChanged(dni: String, fechaNacimiento: String, celular: String,
                          correo: String, password: String){
        _dni.value = dni
        _fechaNacimiento.value = fechaNacimiento
        _correo.value = correo
        _celular.value = celular
        _password.value = password
    }

    fun setearRegistro(){
        _dni.value = ""
        _fechaNacimiento.value = ""
        _correo.value = ""
        _celular.value = ""
        _password.value = ""
    }

    fun registrarPersona(){
        viewModelScope.launch {
            val response = registroUseCase(
                RegistroRequest(
                    dni.value!!,
                    fechaNacimiento.value!!,
                    correo.value!!,
                    celular.value!!,
                    password.value!!)
            )
            _registroResponse.value = Event(response)
        }
    }

}