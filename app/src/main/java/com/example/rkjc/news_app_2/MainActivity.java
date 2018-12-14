package com.example.rkjc.news_app_2;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Network;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;


public class MainActivity extends AppCompatActivity {

    private EditText mSearchBoxEditText;
    private TextView mUrlDisplayTextView;
    private TextView mSearchResultsTextView;
    private ProgressBar mProgressBar;
    private static final String TAG = "MainActivity";

    private RecyclerView mRecyclerView;
    private NewsRecyclerViewAdapter mAdapter;


    //USE THIS
    private RecyclerView fRecyclerView;
    private FRecyclerViewAdapter fAdapter;



    private ArrayList<NewsItem> newsItems = new ArrayList<>();

    private ArrayList<PlayerStatsAL> player = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

        Intent notificationIntent = new Intent(this, AlarmReceiver.class);
        PendingIntent broadcast = PendingIntent.getBroadcast(this, 100, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.SECOND, 10);
        alarmManager.setExact(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), broadcast);


        mSearchBoxEditText = (EditText) findViewById(R.id.et_search_box);

//        mSearchResultsTextView = (TextView) findViewById(R.id.date);

        //mRecyclerView = (RecyclerView)findViewById(R.id.news_recyclerview);
        fRecyclerView = (RecyclerView)findViewById(R.id.news_recyclerview);


        fAdapter = new FRecyclerViewAdapter(this, player);
        //mAdapter = new NewsRecyclerViewAdapter(this, newsItems);
        fRecyclerView.setAdapter(fAdapter);
        fRecyclerView.setLayoutManager(new LinearLayoutManager(this));

//        mRecyclerView.setAdapter(mAdapter);
//        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));


//        NetworkUtils.buildUrl();
//        URL myurl = null;
//        try {
//            myurl = new URL("https://newsapi.org/v1/articles?source=the-next-web&sortBy=latest&source=the-next-web&sortBy=latest&apiKey=4d204dd39e054ad7af357fef89af7eb9");
//        }catch (Exception e){
//            e.printStackTrace();
//        }
        //NewsQueryTask task = new NewsQueryTask();
        //task.execute(myurl);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemThatWasClickedId = item.getItemId();
        if (itemThatWasClickedId == R.id.action_search) {
            Log.d("EDITING", mSearchBoxEditText.getText().toString());
            //HERE CALL FORTNITE
            URL statURL = FNetworkUtils.buildURLStats(mSearchBoxEditText.getText().toString());
            NewsQueryTask t = new NewsQueryTask();

//            URL url = NetworkUtils.buildUrl();
//            NewsQueryTask task = new NewsQueryTask();
            t.execute(statURL);

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
                githubSearchResults = FNetworkUtils.getResponseFromHttpUrl(urls[0]);
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
            player = JSONPlayerUtils.parseNews(s);
            //newsItems = JsonUtils.parseNews(s);

            fAdapter.mNewsItem.addAll(player);
            fAdapter.notifyDataSetChanged();





//
//            mAdapter.mNewsItem.addAll(newsItems);
//            mAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

}
