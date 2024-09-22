//package com.example.myapplication
//import android.util.Log
//import androidx.lifecycle.ViewModel
//import com.google.firebase.auth.FirebaseAuth
//import com.google.firebase.auth.FirebaseAuthException
//import kotlinx.coroutines.flow.MutableStateFlow
//import kotlinx.coroutines.flow.StateFlow
//
//class AuthViewModel : ViewModel()
//{
//    private val _authState = MutableStateFlow<AuthState>(AuthState.NotLoggedIn)
//    val authState:StateFlow<AuthState> = _authState
//    fun login(email: String?, password: String?) {
//        if (email.isNullOrEmpty() || password.isNullOrEmpty()) {
//            _authState.value = AuthState.ErrorLoggedIn("Email or password cannot be empty")
//            return
//        }
//
//        try {
//            FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
//                .addOnCompleteListener { task ->
//                    if (task.isSuccessful) {
//                        _authState.value = AuthState.LoggedIn
//                    } else {
//                        _authState.value = AuthState.ErrorLoggedIn(task.exception?.message ?: "Login failed")
//                    }
//                }
//        } catch (e: FirebaseAuthException) {
//            Log.e("login", "$e")
//        }
//    }
//
//}
//sealed class  AuthState
//{
//    object  NotLoggedIn: AuthState()
//    object LoggedIn: AuthState()
//    data class ErrorLoggedIn(val message: String): AuthState()
//}