package com.sourav.mytestfragment;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class NewsItemAdapter extends RecyclerView.Adapter<NewsItemAdapter.MyViewHolder> {

    private ArrayList<NewsItem> newsItemArrayList;
    private Context context;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView text;
        ImageView image;

        public MyViewHolder(View view) {
            super(view);
            text = view.findViewById(R.id.text);
            image = view.findViewById(R.id.image);

        }
    }


    public NewsItemAdapter(Context context, ArrayList<NewsItem> newsItemArrayList) {
        this.context = context;
        this.newsItemArrayList = newsItemArrayList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.news_list_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        NewsItem newsItem = newsItemArrayList.get(position);
        holder.text.setText(newsItem.getName());

        Log.d("Tagg", "iamge = "+newsItem.getImage());

        Glide.with(context).load(newsItem.getImage()).into(holder.image);

    }

    @Override
    public int getItemCount() {
        return newsItemArrayList.size();
    }


}
