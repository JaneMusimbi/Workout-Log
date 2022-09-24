package com.jane.workoutlog.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jane.workoutlog.Repository.UserRepository
import com.jane.workoutlog.models.LogInResponse
import com.jane.workoutlog.models.RegisterRequest
import com.jane.workoutlog.models.RegisterResponse
import com.jane.workoutlog.models.loginRequest
import kotlinx.coroutines.launch

class UserViewModel:ViewModel() {
    val userRepository = UserRepository()
    val logInResponseLiveData = MutableLiveData<LogInResponse>()
    val errorLiveData = MutableLiveData<String?>()

    val registerResponseLiveData = MutableLiveData<RegisterResponse>()
    val registererrorLiveData = MutableLiveData<String?>()

     fun loginUser(LoginRequest: loginRequest) {
        viewModelScope.launch {
            val response = userRepository.LoginUser(LoginRequest)
            if (response.isSuccessful) {
                logInResponseLiveData.postValue(response.body())
            } else {
                val error =response. errorBody()?.string()
                errorLiveData.postValue(error)
            }
        }
    }

    fun registerUser(registerRequest: RegisterRequest) {
        viewModelScope.launch {
            val response = userRepository.registerUser(registerRequest)
            if (response.isSuccessful) {
                registerResponseLiveData.postValue(response.body())
            } else {
                val error =response. errorBody()?.string()
               registererrorLiveData.postValue(error)
            }
        }
    }
}
