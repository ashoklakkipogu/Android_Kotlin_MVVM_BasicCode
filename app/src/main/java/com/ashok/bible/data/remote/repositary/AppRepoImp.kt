package com.ashok.bible.data.remote.repositary

import com.ashok.bible.data.remote.ApiService
import com.ashok.bible.data.remote.model.BaseModel
import com.ashok.bible.data.remote.model.CarouselModel
import com.lakki.kotlinlearning.data.remote.repositary.AppRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import com.ashok.bible.data.remote.network.ApiDisposable
import com.ashok.bible.data.remote.network.ApiError
import okhttp3.MultipartBody
import javax.inject.Inject

class AppRepoImp @Inject constructor(
    val apiService: ApiService
) :
    AppRepository {
    override fun getCarousel(
        success: (List<CarouselModel>) -> Unit,
        failure: (ApiError) -> Unit,
        terminate: () -> Unit
    ): Disposable {
        return apiService
            .getCarousel()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnTerminate(terminate)
            .subscribeWith(
                ApiDisposable<List<CarouselModel>>(
                    {
                        success(it)
                    },
                    failure
                )
            )
    }
}