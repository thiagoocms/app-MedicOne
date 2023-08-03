package com.app.medicone.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.app.medicone.model.User
import com.app.medicone.repository.user.UserRepository

class LoginViewModel(application: Application): AndroidViewModel(application) {

    private val repository = UserRepository(application.applicationContext)

    
    private var login = MutableLiveData<User>()
    
    fun login(): LiveData<User>{
        return login
    }
    
    fun doLogin(user: String, password: String){
      login.value = repository.findByUserNameAndPassword(user, password)
    }
}