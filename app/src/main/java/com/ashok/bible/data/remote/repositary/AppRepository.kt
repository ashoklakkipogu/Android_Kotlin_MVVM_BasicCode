package com.lakki.kotlinlearning.data.remote.repositary

import com.ashok.bible.data.remote.model.CarouselModel
import io.reactivex.disposables.Disposable
import com.ashok.bible.data.remote.network.ApiError
import okhttp3.MultipartBody

interface AppRepository {
    fun getCarousel(
        success: (List<CarouselModel>) -> Unit,
        failure: (ApiError) -> Unit = {},
        terminate: () -> Unit = {}
    ): Disposable

}