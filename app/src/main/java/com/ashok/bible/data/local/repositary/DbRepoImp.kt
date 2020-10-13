package com.ashok.bible.data.local.repositary

import android.util.Log
import com.ashok.bible.data.local.dao.BibleDao
import com.ashok.bible.data.local.entry.BibleModelEntry
import com.ashok.bible.data.remote.network.ApiDisposable
import com.ashok.bible.data.remote.network.ApiError
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class DbRepoImp @Inject constructor(private val bibleDao: BibleDao) : DbRepository {
    override fun insertNotifications(
        list: List<BibleModelEntry>,
        success: (Unit) -> Unit,
        failure: (ApiError) -> Unit,
        terminate: () -> Unit
    ): Disposable {
        return Observable
            .fromCallable { bibleDao.insertBibleContent(list) }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(
                ApiDisposable<Unit>(
                    {
                        success(it)
                    },
                    failure
                )
            )
    }

}