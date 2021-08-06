package com.empresadeapp.quilmesapp.presentation.login

import androidx.lifecycle.*
import com.empresadeapp.quilmesapp.domain.login.LoginRepo
import com.empresadeapp.quilmesapp.core.Result
import com.empresadeapp.quilmesapp.data.model.User
import kotlinx.coroutines.Dispatchers

class LoginViewModel(private val repo: LoginRepo): ViewModel() {

    private val user = MutableLiveData<User>()

    fun login(numeroUsuario: String, password: String) = liveData(Dispatchers.IO) {
        emit(Result.Loading())
        try {
            emit(Result.Success(repo.login(numeroUsuario,password)))
        } catch (e: Exception){
            emit(Result.Failure(e))
        }
    }

}
class LoginViewModelFactory(private val repo: LoginRepo) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return LoginViewModel(repo) as T
    }
}