package com.ashok.bible.di.builder

import com.ashok.bible.ui.highlights.HighlightsFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuilderModule {
    @ContributesAndroidInjector
    internal abstract fun dashBoardFragment(): HighlightsFragment
}