package com.sourav.mytestfragment;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    private int noOfTabs = 10;

    ArrayList<News> newsArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        viewPager = findViewById(R.id.viewpager);

        tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);




        LayoutInflater inflator = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);


        newsArrayList = new ArrayList<>();
        getNewss();

    }


    private void getNewss() {

        String url = "https://testsite.co.in/Keystone/Api/news_list";
        HashMap<String, String> params = new HashMap<>();
        params.put("user_id", "1");

        new PostDataParser(MainActivity.this, url, params,
                true, new PostDataParser.OnGetResponseListner() {
            @Override
            public void onGetResponse(JSONObject response) {
                if (response != null) {
                    try {

                        Log.d("TAGGG", "data = "+response);

                        int status = response.optInt("status");
                        String news_image_url = response.optString("news_image_url");
                        if (status == 1){

                            JSONArray categories = response.getJSONArray("categories");
                            for (int i = 0; i < categories.length(); i++){
                                JSONObject obj_cat = categories.getJSONObject(i);


                                News news = new News();
                                news.setId(obj_cat.optString("id"));
                                news.setName(obj_cat.optString("name"));


                                ArrayList<NewsItem> newsItemArrayList = new ArrayList<>();
                                JSONArray news_list = obj_cat.getJSONArray("news_list");
                                for (int j = 0; j < news_list.length(); j++){
                                    JSONObject obj_news = news_list.getJSONObject(j);

                                    NewsItem newsItem = new NewsItem();
                                    newsItem.setId(obj_news.optString("id"));
                                    newsItem.setName(obj_news.optString("title"));
                                    newsItem.setImage(news_image_url + obj_news.optString("image"));

                                    newsItemArrayList.add(newsItem);

                                }

                                news.setNewsItemArrayList(newsItemArrayList);
                                newsArrayList.add(news);

                            }

                            setViewPagerAdapter();

                        }


                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }


    private void setViewPagerAdapter(){

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager(), newsArrayList);
        viewPager.setAdapter(adapter);

    }


}
