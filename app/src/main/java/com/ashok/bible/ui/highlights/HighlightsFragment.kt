package com.ashok.bible.ui.highlights

import androidx.lifecycle.ViewModel
import com.ashok.bible.R
import com.ashok.bible.databinding.FragmentHighlightsBinding
import com.lakki.kotlinlearning.view.base.BaseFragment

class HighlightsFragment : BaseFragment<ViewModel, FragmentHighlightsBinding>() {

    override fun getLayoutRes(): Int {
        return R.layout.fragment_highlights
    }

    override fun init() {

    }

    override fun getViewModel(): Class<ViewModel> {
        return ViewModel::class.java
    }
}
