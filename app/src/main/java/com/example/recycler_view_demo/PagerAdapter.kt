package com.example.recycler_view_demo

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class PagerAdapter: FragmentStatePagerAdapter {

    var mNumOfTabs: Int

    constructor(fm: FragmentManager, NumOfTabs: Int): super(fm) {
        this.mNumOfTabs = NumOfTabs
    }

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> TabFragment1()
            1 -> TabFragment2()
            2 -> TabFragment3()
            else -> null!!
        }
    }

    override fun getCount(): Int = mNumOfTabs
}