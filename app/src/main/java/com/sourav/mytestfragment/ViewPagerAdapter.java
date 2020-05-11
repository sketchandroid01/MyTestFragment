package com.sourav.mytestfragment;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {


    private ArrayList<News> newsArrayList;

    public ViewPagerAdapter(FragmentManager fm, ArrayList<News> newsArrayList) {
        super(fm);
        this.newsArrayList = newsArrayList;
    }

    @Override
    public Fragment getItem(int position) {
        News news = newsArrayList.get(position);
        return OneFragment.newInstance(news);
    }

    @Override
    public int getCount() {
        return newsArrayList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        News news = newsArrayList.get(position);
        return news.getName();
    }
}
