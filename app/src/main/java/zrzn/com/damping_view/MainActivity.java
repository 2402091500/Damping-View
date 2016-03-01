package zrzn.com.damping_view;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import zrzn.com.damping_view.DampingView.DampingViewPager;
import zrzn.com.damping_view.fragment.TabFragment;

public class MainActivity extends AppCompatActivity {
    private List<android.support.v4.app.Fragment> fragments;
    private String[] tabs = {"第一","第二","第三"};
    private DampingViewPager dampingViewPager;
    private TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dampingViewPager = (DampingViewPager) findViewById(R.id.damp_viewpager);
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        fragments = new ArrayList<>();
        fragments.add(TabFragment.newInstance("第一页"));
        fragments.add(TabFragment.newInstance("第二页"));
        fragments.add(TabFragment.newInstance("第三页"));

        dampingViewPager.setpagerCount(fragments.size());
        dampingViewPager.setOffscreenPageLimit(fragments.size());
        dampingViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                dampingViewPager.setCurrentIndex(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
        dampingViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public android.support.v4.app.Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return tabs[position];
            }
        });
        tabLayout.setupWithViewPager(dampingViewPager);
    }
}
