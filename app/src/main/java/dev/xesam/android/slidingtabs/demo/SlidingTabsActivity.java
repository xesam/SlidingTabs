package dev.xesam.android.slidingtabs.demo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
        mSlidingTabLayout1.setViewPager(mViewPager1);

        ViewPager mViewPager2 = (ViewPager) findViewById(R.id.pager_2);
        mViewPager2.setAdapter(new SectionsPagerAdapter(getSupportFragmentManager(), 3));
        SlidingTabLayout mSlidingTabLayout2 = (SlidingTabLayout) findViewById(R.id.sliding_tabs_2);
        mSlidingTabLayout2.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {
            @Override
            public int getIndicatorColor(int position) {
                return 0xff5500ff;
            }

            @Override
            public int getDividerColor(int position) {
                return 0xff5500ff;
            }
        });

        mSlidingTabLayout2.setDistributeEvenly(true);
        mSlidingTabLayout2.setViewPager(mViewPager2);


        ViewPager mViewPager3 = (ViewPager) findViewById(R.id.pager_3);
        mViewPager3.setAdapter(new SectionsPagerAdapter(getSupportFragmentManager(), 10));
        SlidingTabLayout mSlidingTabLayout3 = (SlidingTabLayout) findViewById(R.id.sliding_tabs_3);
        mSlidingTabLayout3.setCustomTabView(R.layout.custom_tabview, R.id.custom_tv);
        mSlidingTabLayout3.setDistributeEvenly(true);
        mSlidingTabLayout3.setViewPager(mViewPager3);

    }


    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
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
            return PlaceholderFragment.newInstance(position + 1);
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

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
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
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_sliding_tabs, container, false);
            TextView tv = (TextView) rootView.findViewById(R.id.section_label);
            tv.setText(getArguments().getInt(ARG_SECTION_NUMBER) + "");
            return rootView;
        }
    }

}
