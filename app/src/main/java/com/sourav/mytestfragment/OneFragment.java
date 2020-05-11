package com.sourav.mytestfragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class OneFragment extends Fragment {

    private static final String ARG_SECTION = "ARG_SECTION";
    private News news;


    private RecyclerView recycler_view;

    public OneFragment() {
        // Required empty public constructor
    }

    public static OneFragment newInstance(News news) {
        OneFragment fragment = new OneFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_SECTION, news);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_one, container, false);

        news = (News)getArguments().getSerializable(ARG_SECTION);

        recycler_view = rootView.findViewById(R.id.recycler_view);
        recycler_view.setLayoutManager(new LinearLayoutManager(getActivity()));

        setAdapter();

        return rootView;
    }

    private void setAdapter(){

        NewsItemAdapter newsItemAdapter = new NewsItemAdapter(getActivity(), news.getNewsItemArrayList());
        recycler_view.setAdapter(newsItemAdapter);

    }
}
