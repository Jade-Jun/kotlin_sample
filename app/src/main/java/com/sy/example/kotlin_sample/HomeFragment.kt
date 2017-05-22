package com.sy.example.kotlin_sample

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.app.FragmentStatePagerAdapter
import android.support.v4.view.PagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * Created by SuYa on 2017. 5. 19..
 */

class HomeFragment : Fragment(), View.OnClickListener {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        TODO("let을 이용한 안전한 Null처리")
        view?.let {
            banner_pager.adapter = BannerPagerAdapter(childFragmentManager)

            radio1.setOnClickListener(this)
            radio2.setOnClickListener(this)

            val tabNames = ArrayList<String>()
            tabNames.add(radio1.text.toString())
            tabNames.add(radio2.text.toString())

            view_pager.adapter = CustomPagerAdapter(childFragmentManager, tabNames)
        }
    }

    override fun onClick(v: View?) {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.

        if (v!!.equals(radio1)) {

        } else if (v!!.equals(radio2)) {

        }

    }

    inner class BannerPagerAdapter(fm : FragmentManager) : FragmentStatePagerAdapter(fm) {

        val fragments = ArrayList<Fragment>()

        init {
            update()
        }

        override fun getItemPosition(`object`: Any?): Int {
            return PagerAdapter.POSITION_NONE
        }

        override fun getItem(p0: Int): Fragment {
//            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            val fragment = fragments.get(p0)
            return fragment
        }

        override fun getCount(): Int {
//            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            return  fragments.size
        }

        fun update() {
            fragments.clear()
            for (i in 0..3) {
                val fragment = BannerFragment()
                fragments.add(fragment)
            }
        }
    }

    inner class CustomPagerAdapter(fm: FragmentManager, tabNames : ArrayList<String>) : FragmentPagerAdapter(fm) {

        val names = tabNames

        override fun getItem(p0: Int): Fragment {
            return RecyclerViewFragment()
        }

        override fun getCount(): Int {
            return names.size
        }

        override fun getPageTitle(position: Int): CharSequence {
            return names.get(position)
        }
    }

}