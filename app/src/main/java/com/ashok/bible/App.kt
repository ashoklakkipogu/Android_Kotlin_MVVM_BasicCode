package com.ashok.bible

import android.app.Activity
import android.app.Application
import com.ashok.bible.di.component.AppComponent
import com.ashok.bible.di.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class App : Application(), HasActivityInjector {
    private lateinit var appComponent: AppComponent
    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>
    override fun onCreate() {
        super.onCreate()
        initComponent()
    }

    private fun initComponent() {
        appComponent = DaggerAppComponent.builder()
            .application(this)
            .build()
        appComponent.inject(this)
    }

    private fun appComponent(): AppComponent {
        return appComponent
    }

    override fun activityInjector(): AndroidInjector<Activity> {
        return dispatchingAndroidInjector
    }
}