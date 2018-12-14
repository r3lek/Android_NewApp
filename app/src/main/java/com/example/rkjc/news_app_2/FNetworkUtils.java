package com.example.rkjc.news_app_2;

import android.net.Uri;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class FNetworkUtils {

    /**************************************/
    /********** API URL Endpoint **********/
    /**************************************/

    final static String endpointStats = "https://api.fortnitetracker.com/v1/profile"; //https://api.fortnitetracker.com/v1/profile/{platform}/{epic-nickname}
    final static String endpointMatchHistory =  "https://api.fortnitetracker.com/v1/profile/account"; //https://api.fortnitetracker.com/v1/profile/account/{accountId}/matches
    final static String endpointItemShop = "https://api.fortnitetracker.com/v1/store";
    final static String endpointChallenges = "https://api.fortnitetracker.com/v1/challenges";
    final static String endpointNews = "https://fortnite-public-api.theapinetwork.com/prod09/br_motd/get";
    final static String endpointServerStatus = "https://fortnite-public-api.theapinetwork.com/prod09/status/fortnite_server_status";
    final static String endpointLeakedItems = "https://fortnite-public-api.theapinetwork.com/prod09/upcoming/get";

    //QUERY and VALUES
    final static String key = "TRN-Api-Key";
    final static String value = "1db07a64-64ab-4c8c-9caa-97b4f81ae5d3";

    /**********************/
    /****Stats Endpoint****/
    /**********************/


    public static URL buildURLStats(String userName){

//        if(someAribitraryVariable == null){
//            return null;
//        }
//
//        else{

        // For Testing Now
        ////https://api.fortnitetracker.com/v1/profile/{platform}/{epic-nickname}
        Uri builtUri = Uri.parse(endpointStats).buildUpon()
                .appendPath("ps4") //Add Arbitrary Platform
                .appendPath(userName) //Add Arbitrary Username
                .build();

        URL url = null;

        try{
            url = new URL(builtUri.toString());
        } catch (MalformedURLException e){
            e.printStackTrace();
        }

        Log.d("TAG", url.toString());
        return url;
    }

    /******************************/
    /****Match History Endpoint****/
    /******************************/

    public static URL buildURLMatchHistory(){


        //https://api.fortnitetracker.com/v1/profile/account/{accountId}/matches
        Uri builtUri = Uri.parse(endpointMatchHistory).buildUpon()
                .appendPath("573274ee-19a6-4772-b005-1c871474e67c") //Add arbitrary Epic ID
                .appendPath("matches")
                .build();


        URL url = null;

        try{
            url = new URL(builtUri.toString());

        } catch (MalformedURLException e){
            e.printStackTrace();
        }

        Log.d("TAG", url.toString());
        return url;
    }

    /**************************/
    /****Item Shop Endpoint****/
    /**************************/

    public static URL buildURLMatchItemShop(){



        Uri builtUri = Uri.parse(endpointItemShop).buildUpon()
                .build();


        URL url = null;

        try{
            url = new URL(builtUri.toString());

        } catch (MalformedURLException e){
            e.printStackTrace();
        }

        Log.d("TAG", url.toString());
        return url;
    }

    /***************************/
    /****Challenges Endpoint****/
    /***************************/

    public static URL buildURLChallenges(){


        Uri builtUri = Uri.parse(endpointChallenges).buildUpon()
                .build();


        URL url = null;

        try{
            url = new URL(builtUri.toString());

        } catch (MalformedURLException e){
            e.printStackTrace();
        }

        Log.d("TAG", url.toString());
        return url;
    }

    /*********************/
    /****News Endpoint****/
    /*********************/

    public static URL buildURLNews(){


        Uri builtUri = Uri.parse(endpointNews).buildUpon()
                .build();


        URL url = null;

        try{
            url = new URL(builtUri.toString());

        } catch (MalformedURLException e){
            e.printStackTrace();
        }

        Log.d("TAG", url.toString());
        return url;
    }


    /******************************/
    /****Server Status Endpoint****/
    /******************************/

    public static URL buildURLServerStatus(){


        Uri builtUri = Uri.parse(endpointServerStatus).buildUpon()
                .build();


        URL url = null;

        try{
            url = new URL(builtUri.toString());

        } catch (MalformedURLException e){
            e.printStackTrace();
        }

        Log.d("TAG", url.toString());
        return url;
    }

    /*****************************/
    /****Leaked Items Endpoint****/
    /*****************************/

    public static URL buildURLLeakedItems(){


        Uri builtUri = Uri.parse(endpointLeakedItems).buildUpon()
                .build();


        URL url = null;

        try{
            url = new URL(builtUri.toString());

        } catch (MalformedURLException e){
            e.printStackTrace();
        }

        Log.d("TAG", url.toString());
        return url;
    }




    //Connects by opening a connection with the url and returns the text
    public static String getResponseFromHttpUrl(URL url) throws IOException {
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();


        urlConnection.setRequestProperty(key, value);


        try{
            InputStream in = urlConnection.getInputStream();

            Scanner scanner = new Scanner(in);
            scanner.useDelimiter("\\A");

            boolean hasInput = scanner.hasNext();

            if(hasInput)
                return scanner.next();


            else
                return null;
        } finally {
            urlConnection.disconnect();
        }
    }
}
