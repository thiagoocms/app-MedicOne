package com.app.medicone.viewModel

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.app.medicone.model.User
import com.app.medicone.repository.user.UserRepository
import com.google.android.material.snackbar.Snackbar

class RegisterViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = UserRepository(application.applicationContext)


    private var register = MutableLiveData<Long>()
    private var login = MutableLiveData<User>()

    fun create(): LiveData<Long> {
        return register
    }

    fun doCreate(user: User) {
        if (user.email.isNullOrBlank() || user.username.isNullOrBlank() || user.password.isNullOrBlank() || user.tel.isNullOrBlank()) {
           Toast.makeText(getApplication(), "todos os campos são obrigatorios...", Toast.LENGTH_LONG).show()
        } else {
            var row = repository.save(user)
            register.value = row
            login.value = repository.findByUserNameAndPassword(user.username, user.password)
        }
    }

    fun login(): LiveData<User>{
        return login
    }
}