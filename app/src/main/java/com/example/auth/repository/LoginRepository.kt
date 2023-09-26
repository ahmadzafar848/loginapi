import com.example.auth.models.LoginRequest
import com.example.auth.models.LoginResponse
import com.example.auth.network.ApiService
import retrofit2.Response

class LoginRepository(private val apiService: ApiService) {
    suspend fun login(email: String, password: String): Response<LoginResponse> {
        val loginRequest = LoginRequest(email, password)
        return apiService.loginUser(loginRequest)
    }
}
