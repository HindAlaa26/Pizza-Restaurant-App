package com.example.myapplication
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.api.data.model.NewsResponse
import com.example.myapplication.api.data.network.NewsApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainApi :ViewModel() {
   private val _newsResponse = MutableStateFlow<NewsResponse?>(null)
    val newsResponse: StateFlow<NewsResponse?> get() = _newsResponse
    val apiService = NewsApi.apiService
    fun getAllNews(){
        viewModelScope.launch{
            try {
                var response =apiService.getNews(query = "egypt", apiKey = "a8cfc36d0ef64ef996f83a5d8cca5645")
                if(response.isSuccessful)
                {
                    _newsResponse.value = response.body()
                }
                else{
                    print(response.message())
                }
            }catch (e: Exception) {
                print(e)
            }
        }
    }
}