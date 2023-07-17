package cc.taylorzhang.fragmentvisibility.sample.viewpager

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import cc.taylorzhang.fragmentvisibility.sample.ParentNewWayFragment
import cc.taylorzhang.fragmentvisibility.sample.databinding.ActivityViewPagerBinding


class ViewPagerNewWayNestedActivity : AppCompatActivity() {

    companion object {
        const val TITLE = "Use nested fragment in ViewPager in new way "
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityViewPagerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.title = TITLE
//        binding.viewPager.offscreenPageLimit = 1
        binding.viewPager.adapter = object : FragmentPagerAdapter(
            supportFragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
        ) {

            override fun getCount(): Int = 3

            override fun getItem(position: Int): Fragment {
                return ParentNewWayFragment.newInstance(position)
            }
        }
    }
}