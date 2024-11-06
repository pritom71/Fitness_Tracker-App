package com.stamasoft.ptithom.kotlin_demoapp_navdrawer_v1

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int {
        // Return the number of pages
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        // Return the fragment for the corresponding page
        return when (position) {
            0 -> AllFragment()
            1 -> BeginnerFragment()
            else -> IntermediateFragment()
        }
    }
}
