package dev.xesam.android.slidingtabs.demo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import dev.xesam.android.slidingtabs.R;
import dev.xesam.android.slidingtabs.widgets.SlidingTabLayout;


public class SlidingTabsActivity extends ActionBarActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sliding_tabs);

        ViewPager mViewPager1 = (ViewPager) findViewById(R.id.pager_1);
        mViewPager1.setAdapter(new SectionsPagerAdapter(getSupportFragmentManager()));
        SlidingTabLayout mSlidingTabLayout1 = (SlidingTabLayout) findViewById(R.id.sliding_tabs_1);
        mSlidingTabLayout1.setSelectedIndicatorColors(Color.RED, Color.BLUE);
        mSlidingTabLayout1.setIndicatorBarGravity(SlidingTabLayout.INDICATOR_BAR_GRAVITY_BOTTOM);
        mSlidingTabLayout1.setIndicatorBarColor(Color.YELLOW);
        mSlidingTabLayout1.setViewPager(mViewPager1);

        ViewPager mViewPager2 = (ViewPager) findViewById(R.id.pager_2);
        mViewPager2.setAdapter(new SectionsPagerAdapter(getSupportFragmentManager(), 3));
        SlidingTabLayout mSlidingTabLayout2 = (SlidingTabLayout) findViewById(R.id.sliding_tabs_2);
        mSlidingTabLayout2.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {
            @Override
            public int getIndicatorColor(int position) {
                return Color.rgb(0xff, 0x55, 0);
            }

            @Override
            public int getDividerColor(int position) {
                return Color.GRAY;
            }
        });
        mSlidingTabLayout2.setmCustomTabSizer(new SlidingTabLayout.TabSizer() {
            @Override
            public int getIndicatorBarThickness() {
                return 3;
            }

            @Override
            public int getIndicatorThickness() {
                return 5;
            }

            @Override
            public int getDividerThickness() {
                return 2;
            }

            @Override
            public float getDividerHeight() {
                return 0.8f;
            }
        });
        mSlidingTabLayout2.setDividerEnable(true);
        mSlidingTabLayout2.setDistributeEvenly(true);
        mSlidingTabLayout2.setViewPager(mViewPager2);


        ViewPager mViewPager3 = (ViewPager) findViewById(R.id.pager_3);
        mViewPager3.setAdapter(new SectionsPagerAdapter(getSupportFragmentManager(), 10));
        SlidingTabLayout mSlidingTabLayout3 = (SlidingTabLayout) findViewById(R.id.sliding_tabs_3);
        mSlidingTabLayout3.setCustomTabView(R.layout.custom_tabview, R.id.custom_tv);
        mSlidingTabLayout3.setDistributeEvenly(true);
        mSlidingTabLayout3.setViewPager(mViewPager3);

        ViewPager mViewPager4 = (ViewPager) findViewById(R.id.pager_4);
        mViewPager4.setAdapter(new SectionsPagerAdapter(getSupportFragmentManager(), 3));
        SlidingTabLayout mSlidingTabLayout4 = (SlidingTabLayout) findViewById(R.id.sliding_tabs_4);
        mSlidingTabLayout4.setDistributeEvenly(true);
        mSlidingTabLayout4.setCustomTabAdapter(new SlidingTabLayout.SlidingTabAdapter() {

            private int[] imgs = {
                    R.drawable.ic_menu_account_list,
                    R.drawable.ic_menu_allfriends,
                    R.drawable.ic_menu_always_landscape_portrait
            };

            @Override
            public View getTabView(PagerAdapter pagerAdapter, ViewGroup parent, int position) {
                TextView tv = new TextView(SlidingTabsActivity.this);
                tv.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT));
                tv.setGravity(Gravity.CENTER);
                tv.setCompoundDrawablesWithIntrinsicBounds(0, imgs[position % imgs.length], 0, 0);
                tv.setCompoundDrawablePadding(10);
                tv.setText(pagerAdapter.getPageTitle(position));
                return tv;
            }
        });
        mSlidingTabLayout4.setViewPager(mViewPager4);

    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        private int count = 3;

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        public SectionsPagerAdapter(FragmentManager fm, int count) {
            super(fm);
            this.count = count;
        }

        @Override
        public Fragment getItem(int position) {
            return PlaceholderFragment.newInstance(position);
        }

        @Override
        public int getCount() {
            return count;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return "title" + position;
        }
    }

    public static class PlaceholderFragment extends Fragment {

        private static final String ARG_SECTION_NUMBER = "section_number";

        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            TextView tv = new TextView(getActivity());
            tv.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            tv.setBackgroundColor(Color.rgb(0xe4, 0xe4, 0xe4));
            tv.setGravity(Gravity.CENTER);
            tv.setTextSize(50);
            tv.setText(getArguments().getInt(ARG_SECTION_NUMBER) + "");
            return tv;
        }
    }

}
