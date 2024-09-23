package dev.airdead.eduapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.awaitResponse
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

data class RegisterRequest(
    val username: String,
    val password: String,
    val email: String
)

data class LoginRequest(
    val gmail: String,
    val password: String
)


interface ApiService {

    @POST("api/register")
    @Headers("Content-Type: application/json")
    fun registerUser(@Body request: RegisterRequest): Call<Void>

    @POST("api/login")
    @Headers("Content-Type: application/json")
    fun loginUser(@Body request: LoginRequest): Call<Void>
}

object RetrofitInstance {
    private const val BASE_URL = "http://localhost:8080/"

    val api: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}

class AuthViewModel : ViewModel() {

    fun loginUser(email: String, password: String, onResult: (Boolean) -> Unit) {
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.api
                    .loginUser(LoginRequest(email, password))
                    .awaitResponse()
                if (response.isSuccessful) {
                    onResult(true) // Успешный логин
                } else {
                    onResult(false) // Ошибка логина
                }
            } catch (e: Exception) {
                onResult(false) // Ошибка логина
            }
        }
    }

    fun registerUser(nickname: String, email: String, password: String, onResult: (Boolean) -> Unit) {
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.api
                    .registerUser(RegisterRequest(nickname, password, email))
                    .awaitResponse()
                if (response.isSuccessful) {
                    onResult(true) // Успешная регистрация
                } else {
                    onResult(false) // Ошибка регистрации
                }
            } catch (e: Exception) {
                onResult(false) // Ошибка регистрации
            }
        }
    }
}