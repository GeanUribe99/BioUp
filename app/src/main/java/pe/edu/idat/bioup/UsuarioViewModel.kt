package pe.edu.idat.bioup

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.HttpException

class UsuarioViewModel : ViewModel() {
    private val _user = MutableStateFlow<UserResponse?>(null)
    val user: StateFlow<UserResponse?> get() = _user

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> get() = _error

    fun loadUser(id: String) {
        viewModelScope.launch {
            try {
                val response = RetrofitClient.webService.getInformationUser(id)
                if (response.isSuccessful) {
                    _user.value = response.body()
                } else {
                    _error.value = "Error: ${response.code()}"
                }
            } catch (e: HttpException) {
                _error.value = "HttpException: ${e.message}"
            }
        }
    }
}