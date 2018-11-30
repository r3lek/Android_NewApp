package com.example.rkjc.news_app_2;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

import com.firebase.jobdispatcher.GooglePlayDriver;
import com.firebase.jobdispatcher.JobParameters;
import com.firebase.jobdispatcher.JobService;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class FirebaseJobService extends JobService {
//MINE

    //vic
    NewsItemRepository NewsRepo;
    private AsyncTask mBackgroundTask;


    private static final String TAG = "FirebaseJobService";
    NewsItemRepository newsItemRepository = new NewsItemRepository(this.getApplication());
    //NewsItemRepository.SyncDatabase syn;

    @Override
    public boolean onStartJob(final JobParameters jobParameters) {
        Log.d(TAG, "inside of the firebasejob class ");
        Log.d(TAG, "Will this iterate??? 111");
        //newsItemRepository.syncDB();
        //NewsItemRepository NewsRepo;
        //NewsTask.newsUpdate();
//        NewsRepo.syncDB();
        mBackgroundTask = new AsyncTask() {

            @Override
            protected Object doInBackground(Object[] objects) {

                Context context = FirebaseJobService.this;
                //NewsTask.newsUpdate();
                Log.d(TAG, "Will this iterate??? 222");
                //newsItemRepository.syncDB();
                //NewsRepo.syncDB();
                return null;
            }

            @Override
            protected void onPostExecute(Object o) {
                newsItemRepository.syncDB();
                //NewsRepo.API_to_DB_Synch();
                Log.d(TAG, "Will this iterate??? ");
                //NewsRepo.syncDB();
                jobFinished(jobParameters, false);
            }
        };
        mBackgroundTask.execute();
//        //syn.execute();
//
//        //doBackgroundWork(jobParameters);
//        Log.d(TAG, "After syncing db ");
//
        return true;


    }

//    private void doBackgroundWork(final JobParameters jobParameters) {
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                //repository.syncDB();
//                //syn.execute();
//                Log.d(TAG, "Job has finished syncing");
//                jobFinished(jobParameters, false);
//            }
//        }).start();
//    }

    @Override
    public boolean onStopJob(JobParameters jobParameters) {
        Log.d(TAG, "Job has been cancelled");

        return true;
    }
}

