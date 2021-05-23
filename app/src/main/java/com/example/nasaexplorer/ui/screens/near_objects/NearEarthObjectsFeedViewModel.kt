package com.example.nasaexplorer.ui.screens.near_objects

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nasaexplorer.model.NearEarthObjects
import com.example.nasaexplorer.network.NasaAPI
import com.example.nasaexplorer.network.NetworkConstants
import kotlinx.coroutines.launch
import retrofit2.await
import timber.log.Timber
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.inject.Inject

class NearEarthObjectsFeedViewModel @Inject constructor(private val nasaAPI: NasaAPI) : ViewModel() {

    private val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
    private val todayFormatted = LocalDateTime.now().format(formatter)

    private val _nearEarthObjects = MutableLiveData<NearEarthObjects>()
    val nearEarthObjects: LiveData<NearEarthObjects> get() = _nearEarthObjects


    fun refreshNearEarthObjects() {
        viewModelScope.launch {
            Timber.i("Refresh near Earth Objects")
            val obj = nasaAPI.getNearEarthObjects(todayFormatted,todayFormatted, NetworkConstants.NASA_API_KEY)
            _nearEarthObjects.value = obj.await()
        }
    }
}