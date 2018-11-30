package com.example.rkjc.news_app_2;


import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;
import android.util.Log;

import java.util.List;

public class NewsItemViewModel extends AndroidViewModel{

    private NewsItemRepository repository;
    private LiveData<List<NewsItem>> allNews;

    public NewsItemViewModel(@NonNull Application application) {
        super(application);
        repository = new NewsItemRepository(application);
        allNews = repository.getmAllNews();
    }

    public LiveData<List<NewsItem>> getAllNews() {
        return allNews;
    }

    //to sync the db
    public List<NewsItem> dbSync(){
        Log.d("Log inside view model", "Inside syncing");
        return repository.syncDB();
    }


}
