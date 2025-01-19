package com.example.fooddeliveryapp.ui.features.auth.signup

import android.provider.ContactsContract.CommonDataKinds.Email
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fooddeliveryapp.data.FoodApi
import com.example.fooddeliveryapp.data.models.SignUpRequest
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignUpViewmodel @Inject constructor(private val foodApi: FoodApi) : ViewModel() {
    private val _uiState = MutableStateFlow<SignUpEvent>(SignUpEvent.Idle)
    val uiState=_uiState.asStateFlow()

    fun signUp( name:String,email: String,password:String) {
        _uiState.value=SignUpEvent.Loading
        viewModelScope.launch {
            try {
               val response= foodApi.signUp(SignUpRequest(
                    name=name,
                    email=email,
                    password=password
                ))
                if (response.token.isNotEmpty()) {
                    _uiState.value=SignUpEvent.Success
                }
                else {
                    _uiState.value=SignUpEvent.Error
                }
            }catch (e:Exception) {
                e.printStackTrace()
            }

        }
    }

    sealed class SignUpEvent {
        data object Idle : SignUpEvent()
        data object Success : SignUpEvent()
        data object Error : SignUpEvent()
        data object Loading : SignUpEvent()
    }
}