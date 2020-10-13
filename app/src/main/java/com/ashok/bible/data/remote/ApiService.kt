package com.ashok.bible.data.remote

import io.reactivex.Observable
import retrofit2.http.*
import java.util.*
import retrofit2.http.POST
import android.R.attr.data
import com.ashok.bible.data.remote.model.CarouselModel
import okhttp3.MultipartBody


interface ApiService {
    @GET("carousel")
    fun getCarousel(): Observable<List<CarouselModel>>
}