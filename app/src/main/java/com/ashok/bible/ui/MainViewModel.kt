package com.ashok.bible.ui

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.ashok.bible.data.local.entry.BibleModelEntry
import com.ashok.bible.data.local.repositary.DbRepository
import com.ashok.bible.data.remote.model.CarouselModel
import com.ashok.bible.data.remote.network.ApiError
import com.lakki.kotlinlearning.data.remote.repositary.AppRepository
import com.lakki.kotlinlearning.view.base.BaseViewModel
import javax.inject.Inject

class MainViewModel @Inject constructor(private val appRepository: AppRepository, private val dbRepository: DbRepository) :
    BaseViewModel() {

    val error: MutableLiveData<ApiError> by lazy { MutableLiveData<ApiError>() }
    val carouselData: MutableLiveData<List<CarouselModel>> by lazy { MutableLiveData<List<CarouselModel>>() }

    init {
        loadData()
    }

    private fun loadData() {
        appRepository.getCarousel(
            {
                carouselData.value = it
            },
            {
                error.value = it
            }
        ).also { compositeDisposable.add(it) }
    }
    fun insertBible(notificationModel: List<BibleModelEntry>) {
        val notificationEntryList: ArrayList<BibleModelEntry> = ArrayList()
        for (obj in notificationModel) {
            val notification = BibleModelEntry()
            notification.title = obj.title
            notificationEntryList.add(notification)
        }

        dbRepository.insertNotifications(notificationEntryList,
            {
                Log.i("data", "data........$it")
            },
            {

            }
        ).also { compositeDisposable.dispose() }
    }
}