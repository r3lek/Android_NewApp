package com.example.rkjc.news_app_2;

import android.app.Notification;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.net.Network;
import android.os.AsyncTask;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.app.Notification;

import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.firebase.jobdispatcher.Constraint;
import com.firebase.jobdispatcher.FirebaseJobDispatcher;
import com.firebase.jobdispatcher.GooglePlayDriver;
import com.firebase.jobdispatcher.Job;
import com.firebase.jobdispatcher.Lifetime;
import com.firebase.jobdispatcher.RetryStrategy;
import com.firebase.jobdispatcher.Trigger;

public class MainActivity extends AppCompatActivity {



    //Hw2 code
    private NewsItemViewModel newsItemViewModel;

    //hw3
    private FirebaseJobDispatcher jobDispatcher;
    private static final String Job_Tag = "my_job_tag";

    //HW3 notification

    private NotificationManagerCompat notificationManager;



    private EditText mSearchBoxEditText;
    private TextView mUrlDisplayTextView;
    private TextView mSearchResultsTextView;
    private ProgressBar mProgressBar;
    private static final String TAG = "MainActivity";

    private RecyclerView mRecyclerView;
    private NewsRecyclerViewAdapter mAdapter;
    private List<NewsItem> newsItems = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSearchResultsTextView = (TextView) findViewById(R.id.date);

        mRecyclerView = (RecyclerView)findViewById(R.id.news_recyclerview);
        mAdapter = new NewsRecyclerViewAdapter(this, newsItems);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        //Code for hw 2
        newsItemViewModel = ViewModelProviders.of(this).get(NewsItemViewModel.class);
        newsItemViewModel.getAllNews().observe(this, new Observer<List<NewsItem>>() {
            @Override
            public void onChanged(@Nullable List<NewsItem> newsItems) {
                //Toast.makeText(MainActivity.this, "onChanged", Toast.LENGTH_SHORT).show(); //it does show toast
                mAdapter.setNewsItems(newsItems);
            }
        });






//        NetworkUtils.buildUrl();
//        URL myurl = null;
//        try {
//            myurl = new URL("https://newsapi.org/v1/articles?source=the-next-web&sortBy=latest&source=the-next-web&sortBy=latest&apiKey=4d204dd39e054ad7af357fef89af7eb9");
//        }catch (Exception e){
//            e.printStackTrace();
//        }
        //NewsQueryTask task = new NewsQueryTask();
        //task.execute(myurl);

        executeJobDispatcher();



        notificationManager = NotificationManagerCompat.from(this);

        sendOnChannel1();


    }

    public void sendOnChannel1() {
        Notification notification = new NotificationCompat.Builder(this, Notify.CHANNEL_1_ID)
                .setSmallIcon(R.drawable.ic_1)
                .setContentTitle("This is a test notification")
                .setContentText("Content Text")
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();

        Log.d("NotifcationTAG", "Notification action!!!");
        notificationManager.notify(1,notification);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemThatWasClickedId = item.getItemId();
        if (itemThatWasClickedId == R.id.action_search) {
//            URL url = NetworkUtils.buildUrl();
//            NewsQueryTask task = new NewsQueryTask();
//            task.execute(url);

            newsItems = newsItemViewModel.dbSync();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    // DONE (1) Create a class called GithubQueryTask that extends AsyncTask<URL, Void, String>
    public class NewsQueryTask extends AsyncTask<URL, Void, String>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            //mProgressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected String doInBackground(URL... urls) {
            String githubSearchResults = "";
            try {
                githubSearchResults = NetworkUtils.getResponseFromHttpUrl(urls[0]);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return githubSearchResults;
        }

        @Override
        protected void onPostExecute(String s) {
            Log.d("mycode", s);
            super.onPostExecute(s);
            //mProgressBar.setVisibility(View.GONE);
            newsItems = JsonUtils.parseNews(s);
            mAdapter.mNewsItem.addAll(newsItems);
            mAdapter.notifyDataSetChanged();
        }
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    public void executeJobDispatcher(){

        jobDispatcher = new FirebaseJobDispatcher(new GooglePlayDriver(this));


        Job job = jobDispatcher.newJobBuilder()
                // Service will call from 'MyJobService'
                .setService(FirebaseJobService.class)
                // Will be 'my_job_tag'
                .setTag(Job_Tag)
                // Job will be executed through the lifetime of the application
                .setRecurring(true)
                // Set time of execution
                .setLifetime(Lifetime.FOREVER)
                // Sets the job to be repeated
                .setTrigger(Trigger.executionWindow(10,10))
                // overwrite an existing job with the same tag
                .setReplaceCurrent(true)
                // retry with exponential backoff
                .setRetryStrategy(RetryStrategy.DEFAULT_LINEAR)
                // sets constraints based on device status
                .setConstraints(
                        // only executes when device is on a network (does http request from news API)
                        Constraint.ON_ANY_NETWORK
                )
                .build();

        jobDispatcher.mustSchedule(job);
        Toast.makeText(this, "Job Scheduled", Toast.LENGTH_LONG).show();
        //Date of newest: 2018-11-29T22:26:10Z
    }

    //stating hw 3
}
