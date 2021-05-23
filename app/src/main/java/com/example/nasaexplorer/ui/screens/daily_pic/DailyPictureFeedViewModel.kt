package com.example.nasaexplorer.ui.screens.daily_pic

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nasaexplorer.model.DailyPicture
import com.example.nasaexplorer.network.NasaAPI
import com.example.nasaexplorer.network.NetworkConstants
import kotlinx.coroutines.launch
import retrofit2.await
import javax.inject.Inject


class DailyPictureFeedViewModel @Inject constructor(private val nasaAPI: NasaAPI) : ViewModel() {

    private val _dailyPictureLiveData = MutableLiveData<DailyPicture>()
    val dailyPictureLiveData: LiveData<DailyPicture> get() = _dailyPictureLiveData

    fun refreshDaily() {
        viewModelScope.launch {
            val picCall = nasaAPI.getDailyPicture(NetworkConstants.NASA_API_KEY)
            _dailyPictureLiveData.value = picCall.await()
        }
    }

}