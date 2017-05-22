package com.sy.example.kotlin_sample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tabnames = ArrayList<String>();
        tabnames.add("홈")
        tabnames.add("요일")

        val pageradapter = MainPagerAdapter(supportFragmentManager, tabnames)
        view_pager.adapter = pageradapter

    }

    inner class MainPagerAdapter(fm: FragmentManager, tabNames : ArrayList<String>) : FragmentPagerAdapter(fm) {

        val names = tabNames

        init {

        }

        override fun getItem(p0: Int): Fragment {
//            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.

            val selName = names.get(p0)

            if (selName.equals("홈")) {
                return HomeFragment()
            } else {
                return RecyclerViewFragment()
            }
        }

        override fun getCount(): Int {
//            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            return names.size
        }

        override fun getPageTitle(position: Int): CharSequence {
            return names.get(position)
        }
    }

}
