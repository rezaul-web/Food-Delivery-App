package com.example.fooddeliveryapp.ui.features.auth.login

import android.provider.ContactsContract.CommonDataKinds.Email
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fooddeliveryapp.data.FoodApi
import com.example.fooddeliveryapp.data.models.LogInRequest
import com.example.fooddeliveryapp.data.models.SignUpRequest
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LogInViewmodel @Inject constructor(private val foodApi: FoodApi) : ViewModel() {
    private val _uiState = MutableStateFlow<LoginEvent>(LoginEvent.Idle)
    val uiState=_uiState.asStateFlow()

    fun login( email: String,password:String) {
        _uiState.value=LoginEvent.Loading
        viewModelScope.launch {
            try {
               val response= foodApi.logIn(LogInRequest(
                    email=email,
                    password=password
                ))
                if (response.token.isNotEmpty()) {
                    _uiState.value=LoginEvent.Success
                }
                else {
                    _uiState.value=LoginEvent.Error
                }
            }catch (e:Exception) {
                e.printStackTrace()
            }

        }
    }

    sealed class LoginEvent {
        data object Idle : LoginEvent()
        data object Success : LoginEvent()
        data object Error : LoginEvent()
        data object Loading : LoginEvent()
    }
}