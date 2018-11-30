package com.example.rkjc.news_app_2;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;
import java.util.List;


public class NewsItemRepository {

    private NewsItemDao mNewsItemDao;
    private LiveData<List<NewsItem>> mAllNews;

    //Get all from db
    public NewsItemRepository(Application application){
        NewsItemDatabase db = NewsItemDatabase.getDatabase(application.getApplicationContext());
        mNewsItemDao = db.newsItemDao();
        mAllNews = mNewsItemDao.loadAllNewsItems();
    }


    //gets all items
    public LiveData<List<NewsItem>> getmAllNews() {
        return mAllNews;
    }

//    public void setNewItems(LiveData<List<NewsItem>> allNews){
//        this.mAllNews = allNews;
//    }

    public List<NewsItem> syncDB(){
        new SyncDatabase(mNewsItemDao).execute();
        return null;
    }

    //sync database with api and remove everything inside db
    private static class SyncDatabase extends AsyncTask<Void, Void, List<NewsItem>>{
        private NewsItemDao newsItemDao;
       // private NewsItemRepository newsItemRepository;

        private SyncDatabase(NewsItemDao newsItemDao){
            this.newsItemDao = newsItemDao;
            //this.newsItemRepository = newsItemRepository;
        }

        @Override
        protected List<NewsItem> doInBackground(Void... voids) {
            String builtNewsList = null;
            List<NewsItem> items = null; //list that will hold all articles

            try {
                //delete all from db first
                newsItemDao.clearAll();
                builtNewsList = NetworkUtils.getResponseFromHttpUrl(NetworkUtils.buildUrl());
                items = JsonUtils.parseNews(builtNewsList);
                newsItemDao.insert(items);


            } catch (IOException e) {
                e.printStackTrace();
            }

            return items;
        }
    }




}
