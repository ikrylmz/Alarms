package com.example.alarms;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PagerAdapter extends FragmentPagerAdapter {


    public PagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new HomeFragment();
                break;
            case 1:
                fragment = new AlarmListFragment();
                break;
            case 2:
                fragment = new AdditionFragment();
                break;
            case 3:
                fragment = new SettingsFragment();
        }
        return fragment;
    }
    @Override
    public int getCount() {

        return 4;
    }
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Home Fragment";
            case 1:
                return "Alarms Fragment";
            case 2:
                return "Settings Fragment";
        }
        return null;
    }
}
