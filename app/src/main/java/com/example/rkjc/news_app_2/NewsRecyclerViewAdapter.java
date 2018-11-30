package com.example.rkjc.news_app_2;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;


public class NewsRecyclerViewAdapter  extends RecyclerView.Adapter<NewsRecyclerViewAdapter.NewsViewHolder> {

    Context mContext;
    List<NewsItem> mNewsItem;

    public NewsRecyclerViewAdapter(Context mContext, List<NewsItem> mNewsItem) {
        this.mContext = mContext;
        this.mNewsItem = mNewsItem;
    }

    @Override
    public NewsRecyclerViewAdapter.NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(R.layout.news_item, parent, shouldAttachToParentImmediately); //hopefully correct
        NewsViewHolder viewHolder = new NewsViewHolder(view);
        //view.setOnClickListener();

        return viewHolder;

    }

    @Override
    public void onBindViewHolder(NewsRecyclerViewAdapter.NewsViewHolder holder, final int position) {
        //view.setOnClickListener();

//        holder.url.setOnClickListener((new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Uri url = Uri.parse(mNewsItem.get(position).getUrl());
//
//                Intent i = new Intent(Intent.ACTION_VIEW, url);
//                i.setData(url);
//
//                mContext.startActivity(i);
//            }
//        }));
        holder.bind(position);
    }


    public void setNewsItems(List<NewsItem> newsItems){
        mNewsItem = newsItems;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mNewsItem.size();
    }

    public class NewsViewHolder extends RecyclerView.ViewHolder{
        TextView title;
        TextView description;
        TextView date;
        TextView url;


        public NewsViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title);
            date = (TextView) itemView.findViewById(R.id.date);
            description = (TextView) itemView.findViewById(R.id.description);
            url = (TextView) itemView.findViewById(R.id.url);

            itemView.setOnClickListener(
                    (new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Uri urls = Uri.parse(url.getText().toString());

                            Intent i = new Intent(Intent.ACTION_VIEW, urls);
                            i.setData(urls);

                            mContext.startActivity(i);
                        }
                    })
            );

        }

        void bind(int listIndex) {

            title.setText("Title"+ mNewsItem.get(listIndex).getTitle());
            description.setText("Description"+ mNewsItem.get(listIndex).getDescription());
            date.setText("Date:"+ mNewsItem.get(listIndex).getPublishedAt());
            url.setText(mNewsItem.get(listIndex).getUrl());
        }
    }
}
