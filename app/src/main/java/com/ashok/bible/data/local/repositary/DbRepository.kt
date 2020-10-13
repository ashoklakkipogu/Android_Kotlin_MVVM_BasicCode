package com.ashok.bible.data.local.repositary

import com.ashok.bible.data.local.entry.BibleModelEntry
import com.ashok.bible.data.remote.network.ApiError
import io.reactivex.disposables.Disposable


interface DbRepository {
    fun insertNotifications(
        list: List<BibleModelEntry>,
        success: (Unit) -> Unit,
        failure: (ApiError) ->Unit = {},
        terminate: () ->Unit = {}
    ): Disposable
}