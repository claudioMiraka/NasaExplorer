package com.example.nasaexplorer.ui.screens.mars_pictures

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nasaexplorer.model.MarsPictures
import com.example.nasaexplorer.network.NasaAPI
import com.example.nasaexplorer.network.NetworkConstants
import kotlinx.coroutines.launch
import retrofit2.await
import javax.inject.Inject

class MarsPicturesViewModel @Inject constructor(private val nasaAPI: NasaAPI) : ViewModel() {

    private val _marsPicturesLiveData = MutableLiveData<MarsPictures>()
    val marsPicturesLiveData: LiveData<MarsPictures> get() = _marsPicturesLiveData

    fun refreshPictures() {
        viewModelScope.launch {
            val picCall = nasaAPI.getMarsPictures("2021-5-18" ,NetworkConstants.NASA_API_KEY)
            _marsPicturesLiveData.value = picCall.await()
        }
    }

}