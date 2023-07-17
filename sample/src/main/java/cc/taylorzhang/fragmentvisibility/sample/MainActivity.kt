package cc.taylorzhang.fragmentvisibility.sample

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import cc.taylorzhang.fragmentvisibility.sample.databinding.ActivityMainBinding
import cc.taylorzhang.fragmentvisibility.sample.viewpager.ViewPager2Activity
import cc.taylorzhang.fragmentvisibility.sample.viewpager.ViewPagerNewWayActivity
import cc.taylorzhang.fragmentvisibility.sample.viewpager.ViewPagerNewWayNestedActivity
import cc.taylorzhang.fragmentvisibility.sample.viewpager.ViewPagerOldWayActivity
import cc.taylorzhang.fragmentvisibility.sample.viewpager.ViewPagerOldWayNestedActivity

/**
 * <pre>
 *     author : Taylor Zhang
 *     time   : 2021/02/24
 *     desc   : Main activity.
 *     version: 1.0.0
 * </pre>
 */
class MainActivity : AppCompatActivity() {

    private val mList = ArrayList<Pair<String, Class<*>>>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initList()
        binding.listView.adapter = ArrayAdapter(
            this, android.R.layout.simple_list_item_1, mList.map { it.first }
        )
        binding.listView.setOnItemClickListener { _, _, position, _ ->
            startActivity(Intent(this, mList[position].second))
        }
    }

    private fun initList() {
        mList.add(DirectlyActivity.TITLE to DirectlyActivity::class.java)
        mList.add(ContainerOldWayActivity.TITLE to ContainerOldWayActivity::class.java)
        mList.add(ContainerNewWayActivity.TITLE to ContainerNewWayActivity::class.java)
        mList.add(NestedOldWayActivity.TITLE to NestedOldWayActivity::class.java)
        mList.add(NestedNewWayActivity.TITLE to NestedNewWayActivity::class.java)

        mList.add(ViewPagerOldWayActivity.TITLE to ViewPagerOldWayActivity::class.java)
        mList.add(ViewPagerNewWayActivity.TITLE to ViewPagerNewWayActivity::class.java)
        mList.add(ViewPager2Activity.TITLE to ViewPager2Activity::class.java)
        mList.add(ViewPagerOldWayNestedActivity.TITLE to ViewPagerOldWayNestedActivity::class.java)
        mList.add(ViewPagerNewWayNestedActivity.TITLE to ViewPagerNewWayNestedActivity::class.java)
    }
}