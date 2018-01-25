/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.miwok;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    FragmentPagerAdapter adapterViewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager vpPager = (ViewPager) findViewById(R.id.pager);
        adapterViewPager = new MyPagerAdapter(this, getSupportFragmentManager());
        vpPager.setAdapter(adapterViewPager);
        vpPager.setCurrentItem(1);
        vpPager.setPageTransformer(true, new ZoomOutPageTransformer());

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab);
        tabLayout.setupWithViewPager(vpPager);
    }

    public static class MyPagerAdapter extends FragmentPagerAdapter {
        private static int NUM_ITEMS = 4;
        private Context mContext;

        public MyPagerAdapter( Context context, FragmentManager fragmentManager ) {
            super(fragmentManager);
            mContext = context;
        }

        // Returns total number of pages
        @Override
        public int getCount() {
            return NUM_ITEMS;
        }

        // Returns the fragment to display for that page
        @Override
        public Fragment getItem( int position ) {
            switch (position) {
                case 0: // Fragment # 0 - This will show FirstFragment
                    // return FirstFragment.newInstance(0, "Page # 1");
                    return new ColorsFragment( );
                case 1: // Fragment # 0 - This will show FirstFragment different title
                    return new NumbersFragment( );
                case 2: // Fragment # 1 - This will show SecondFragment
                    return new FamillyFragment( );
                case 3:
                    return new PhrasesFragment( );
                default:
                    return null;
            }
        }

        // Returns the page title for the top indicator
        @Override
        public CharSequence getPageTitle( int position ) {
            if (position == 0) {
                return mContext.getString(R.string.category_numbers);
            } else if (position == 1) {
                return mContext.getString(R.string.category_family);
            } else if (position == 2) {
                return mContext.getString(R.string.category_colors);
            } else {
                return mContext.getString(R.string.category_phrases);
            }
        }
    }
}
